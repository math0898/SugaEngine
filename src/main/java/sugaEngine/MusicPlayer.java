package sugaEngine;

import javax.sound.sampled.*;
import java.util.Objects;

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
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(MusicPlayer.class.getResourceAsStream(file)));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the volume of the music to the given value.
     *
     * @param val The volume level to set the music to.
     */
    public void setVolume (float val) { // todo make actual volume changes.
        if (clip.isRunning()) clip.stop();
        else clip.start();
    }
}
