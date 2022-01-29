package sugaEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The MusicPlayer class is meant to play music at varying volume levels with the possibility to pause or resume
 * playback. It is not meant to work with sound effects.
 *
 * @author Sugaku
 */
public class MusicPlayer {

    /**
     * The clip that this music player is playing.
     */
    protected Clip clip;

    /**
     * Creates a new Music Player instance by loading the given file.
     *
     * @param file The file to load the music from.
     */
    public MusicPlayer (String file) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(MusicPlayer.class.getResourceAsStream(file));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
