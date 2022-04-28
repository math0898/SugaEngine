package suga.engine.sound;

import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
     * Clears the list of sounds currently loaded by the SoundManager. Should be called before loading a new scene to
     * prevent too many files from being stored in RAM.
     */
    @Override
    public void clearSounds () {
        if (nowPlaying != null) nowPlaying.stop();
        nowPlaying = null;
        soundEffects.clear();
        musicTracks.clear();
        ambienceSounds.clear();
        ambienceIntervals.clear();
    }

    /**
     * Adds a new sound effect to the sound manager which can then be played upon request.
     *
     * @param name The name of the sound effect.
     * @param path The path to the sound effect. The system will first search class resources then the local disk.
     * @return True if the effect is found and then added to the SoundManager. Otherwise, false.
     */
    @Override
    public boolean addSoundEffect (String name, String path) { // todo refactor... this code will basically be repeated 3 times.
        Clip c;
        try {
            c = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return false;
        }
        InputStream stream = getClass().getResourceAsStream(path);
        if (InputStream.nullInputStream().equals(stream) || stream == null) {
            try {
                stream = new FileInputStream(path);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (InputStream.nullInputStream().equals(stream)) return false;
        try {
            stream = new BufferedInputStream(stream);
            c.open(AudioSystem.getAudioInputStream(stream));
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
            return false;
        }
        soundEffects.put(name, c);
        return true;
    }

    /**
     * Removes sound effects with the given name.
     *
     * @param name The name of the sound effect to remove.
     */
    @Override
    public void removeSoundEffect (String name) {
        // todo
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
            } else {
                System.out.println("Audio System Error. Attempted to modify volume of clip but action is not supported.");
            }
        }
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
        // todo
    }

    /**
     * Stops the currently playing music track without starting a new one.
     */
    @Override
    public void stopMusic () {
        // todo
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
