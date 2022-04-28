package suga.engine.sound;

import suga.engine.logger.Level;

import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static suga.engine.GameEngine.getLogger;

/**
 * The JavaxSoundManager is a SoundManager that outputs sound using the classes provided by javax and javax.sampled.
 *
 * @author Sugaku
 */
public class JavaxSoundManager implements SoundManager {

    /**
     * A map of sound effects by their name.
     */
    private final Map<String, Clip> soundEffects = new HashMap<>();

    /**
     * A map of music tracks by their name.
     */
    private final Map<String, Clip> musicTracks = new HashMap<>();

    /**
     * The currently playing music track.
     */
    private Clip nowPlaying = null;

    /**
     * A map of the ambience sound effects by their name.
     */
    private final Map<String, Clip> ambienceSounds = new HashMap<>();

    /**
     * A map of the intervals at which to play ambience sounds.
     */
    private final Map<String, Integer> ambienceIntervals = new HashMap<>();

    /**
     * Attempts to find the clip in the resource path, and if not found searches the local disk.
     *
     * @param path The path to attempt and find the clip at.
     * @return Either the found clip or null.
     */
    protected Clip findClip (String path) { // todo could be nice to reduce the scope of this method.
        Clip toReturn;
        try {
            toReturn = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            getLogger().log("JavaxSoundManager: Out line is not available.", Level.EXCEPTION);
            getLogger().log(e);
            return null;
        }
        InputStream stream = getClass().getResourceAsStream(path);
        if (InputStream.nullInputStream().equals(stream) || stream == null) {
            try {
                stream = new FileInputStream(path);
            } catch (IOException e) {
                getLogger().log("JavaxSoundManager: Clip was not found as a resource, and an exception occurred searching the disk.", Level.EXCEPTION);
                getLogger().log(e);
                return null;
            }
        }
        if (InputStream.nullInputStream().equals(stream)) {
            getLogger().log("JavaxSoundManager: The found file, or resource, is a null input stream.", Level.EXCEPTION);
            return null;
        }
        try {
            stream = new BufferedInputStream(stream);
            toReturn.open(AudioSystem.getAudioInputStream(stream));
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            getLogger().log("JavaxSoundManager: An exception occurred attempting to convert the input stream to a clip.", Level.EXCEPTION);
            getLogger().log(e);
            return null;
        }
        return toReturn;
    }

    /**
     * Clears the list of sounds currently loaded by the SoundManager. Should be called before loading a new scene to
     * prevent too many files from being stored in RAM.
     */
    @Override
    public void clearSounds () {
        stopMusic();
        soundEffects.clear();
        musicTracks.clear();
        ambienceSounds.clear();
        ambienceIntervals.clear();
        getLogger().log("JavaxSoundManager: Cleared all loaded sounds.", Level.DEBUG);
    }

    /**
     * Adds a new sound effect to the sound manager which can then be played upon request.
     *
     * @param name The name of the sound effect.
     * @param path The path to the sound effect. The system will first search class resources then the local disk.
     * @return True if the effect is found and then added to the SoundManager. Otherwise, false.
     */
    @Override
    public boolean addSoundEffect (String name, String path) {
        Clip c = findClip(path);
        if (c == null) {
            getLogger().log("JavaxSoundManager: Was unable to add sound effect by the name of: " + name, Level.DEBUG);
            return false;
        }
        soundEffects.put(name, c);
        getLogger().log("JavaxSoundManager: Added sound effect by the name of: " + name, Level.DEBUG);
        return true;
    }

    /**
     * Removes sound effects with the given name.
     *
     * @param name The name of the sound effect to remove.
     */
    @Override
    public void removeSoundEffect (String name) {
        soundEffects.remove(name).close();
        getLogger().log("JavaxSoundManager: Removed sound effect by the name of: " + name, Level.DEBUG);
    }

    /**
     * Plays a specific sound effect with 50% volume.
     *
     * @param name The sound effect to play.
     */
    @Override
    public void playSoundEffect (String name) {
        playSoundEffect(name, 0.5f);
    }

    /**
     * Plays a specific sound effect with the given volume.
     *
     * @param name The sound effect to play.
     * @param vol  The volume to play the sound effect at. Range: [0, 1]
     */
    @Override
    public void playSoundEffect (String name, float vol) {
        Clip effect = soundEffects.get(name);
        if (effect != null) {
            effect.start();
            if (effect.isControlSupported(FloatControl.Type.VOLUME)) {
                FloatControl control = (FloatControl) effect.getControl(FloatControl.Type.VOLUME);
                assert control != null; // Checked if supported first.
                control.setValue(vol);
            } else getLogger().log("JavaxSoundManager: Attempted to modify volume of clip but action is not supported.", Level.WARNING);
            getLogger().log("JavaxSoundManager: Played requested sound effect: " + name, Level.DEBUG);
        } else getLogger().log("JavaxSoundManager: Effect was not found in the map of sound effects: " + name, Level.EXCEPTION);
    }

    /**
     * Adds a new music track to be played in the background on demand.
     *
     * @param name The name of the music track.
     * @param path The path of the music track. The system will first search class resources then the local disk.
     * @return True if the music track is found and then added to the SoundManager. Otherwise, false.
     */
    @Override
    public boolean addMusicTrack (String name, String path) {
        return false;// todo
    }

    /**
     * Removes music tracks with the given name.
     *
     * @param name The name of the music track to remove.
     */
    @Override
    public void removeMusicTrack (String name) {
        // todo
    }

    /**
     * Plays a specific music track at 50% volume. This track will repeat until another track is called, or it is
     * requested that music playback stops.
     *
     * @param name The name of the music track to play.
     */
    @Override
    public void playMusicTrack (String name) {
        playMusicTrack(name, 0.5f);
    }

    /**
     * Plays a specific music track with the given volume. This track will repeat until another track is called, or it
     * is requested that music playback stops.
     *
     * @param name The name of the music track to play.
     * @param vol  The volume to play the music track at. Range: [0, 1]
     */
    @Override
    public void playMusicTrack (String name, float vol) {
        Clip track = musicTracks.get(name);
        if (track != null) {
            stopMusic();
            track.start();
            track.loop(Clip.LOOP_CONTINUOUSLY);
            nowPlaying = track;
            if (track.isControlSupported(FloatControl.Type.VOLUME)) {
                FloatControl control = (FloatControl) track.getControl(FloatControl.Type.VOLUME);
                assert control != null; // Checked if supported first.
                control.setValue(vol);
            } else getLogger().log("JavaxSoundManager: Attempted to modify volume of clip but action is not supported.", Level.WARNING);
            getLogger().log("JavaxSoundManager: Played requested music track: " + name, Level.DEBUG);
        } else getLogger().log("JavaxSoundManager: Track was not found in the map of music tracks: " + name, Level.EXCEPTION);
    }

    /**
     * Stops the currently playing music track without starting a new one.
     */
    @Override
    public void stopMusic () {
        if (nowPlaying != null) {
            nowPlaying.stop();
            nowPlaying = null;
            getLogger().log("JavaxSoundManager: Stopped currently playing music track.", Level.DEBUG);
        }
    }

    /**
     * Adds a new ambience sound to be played in the background on an interval. Probability for the sound to play slowly
     * increases until it's played at which point the probability becomes zero again.
     *
     * @param interval The interval after which the sound would have been played at least once. The time unit is millis.
     * @param name     The name of the ambience sound.
     * @param path     The path of the ambience sound. The system will first search class resources then the local disk.
     * @return True if the ambience sound is found and then added to the SoundManager. Otherwise, false.
     */
    @Override
    public boolean addAmbienceEffect (int interval, String name, String path) {
        return false;// todo
    }

    /**
     * Removes ambience sounds with the given name.
     *
     * @param name The name of the ambience sound to remove.
     */
    @Override
    public void removeAmbienceEffect (String name) {
        // todo
    }

    /**
     * When called rolls the dice on whether any ambience sounds should be played or not.
     */
    @Override
    public void ambienceSoundRoll () {
        // todo
    }
}
