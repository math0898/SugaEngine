package suga.engine.sound;

/**
 * The SoundManager is used to manage sounds being played to the player. It includes systems for ambience tracks as well
 * as specific sound effects.
 *
 * @author Sugaku
 */
public interface SoundManager { // todo audio transitions, blending from one track to another, volume swells etc.

    /**
     * Clears the list of sounds currently loaded by the SoundManager. Should be called before loading a new scene to
     * prevent too many files from being stored in RAM.
     */
    void clearSounds ();

    /**
     * Adds a new sound effect to the sound manager which can then be played upon request.
     *
     * @param name The name of the sound effect.
     * @param path The path to the sound effect. The system will first search class resources then the local disk.
     * @return True if the effect is found and then added to the SoundManager. Otherwise, false.
     */
    boolean addSoundEffect (String name, String path);

    /**
     * Removes sound effects with the given name.
     *
     * @param name The name of the sound effect to remove.
     */
    void removeSoundEffect (String name);

    /**
     * Plays a specific sound effect with 50% volume.
     *
     * @param name The sound effect to play.
     */
    void playSoundEffect (String name);

    /**
     * Plays a specific sound effect with the given volume.
     *
     * @param name The sound effect to play.
     * @param vol  The volume to play the sound effect at. Range: [0, 1]
     */
    void playSoundEffect (String name, float vol);

    /**
     * Adds a new music track to be played in the background on demand.
     *
     * @param name The name of the music track.
     * @param path The path of the music track. The system will first search class resources then the local disk.
     * @return True if the music track is found and then added to the SoundManager. Otherwise, false.
     */
    boolean addMusicTrack (String name, String path);

    /**
     * Removes music tracks with the given name.
     *
     * @param name The name of the music track to remove.
     */
    void removeMusicTrack (String name);

    /**
     * Plays a specific music track at 50% volume. This track will repeat until another track is called, or it is
     * requested that music playback stops.
     *
     * @param name The name of the music track to play.
     */
    void playMusicTrack (String name);

    /**
     * Plays a specific music track with the given volume. This track will repeat until another track is called, or it
     * is requested that music playback stops.
     *
     * @param name The name of the music track to play.
     * @param vol  The volume to play the music track at. Range: [0, 1]
     */
    void playMusicTrack (String name, float vol);

    /**
     * Stops the currently playing music track without starting a new one.
     */
    void stopMusic ();

    /**
     * Adds a new ambience sound to be played in the background on an interval. Probability for the sound to play slowly
     * increases until it's played at which point the probability becomes zero again.
     *
     * @param interval The interval after which the sound would have been played at least once. The time unit is the
     *                 number of times ambienceSoundRoll is called.
     * @param name     The name of the ambience sound.
     * @param path     The path of the ambience sound. The system will first search class resources then the local disk.
     * @return True if the ambience sound is found and then added to the SoundManager. Otherwise, false.
     */
    boolean addAmbienceEffect (int interval, String name, String path);

    /**
     * Removes ambience sounds with the given name.
     *
     * @param name The name of the ambience sound to remove.
     */
    void removeAmbienceEffect (String name);

    /**
     * When called rolls the dice on whether any ambience sounds should be played or not.
     */
    void ambienceSoundRoll ();
}
