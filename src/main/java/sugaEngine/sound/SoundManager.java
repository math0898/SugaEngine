package sugaEngine.sound;

import javax.sound.sampled.*;
import java.util.Objects;

/**
 * The SoundManager class is used to play sound effects to the player. It can be used for soundtracks but that is not
 * its intended use case.
 *
 * @author Sugaku
 */
public class SoundManager<T extends SoundEffects> {

    /**
     * A list of clips that are currently being played by the SoundManager.
     */
    private Clip clip;

    /**
     * Control for the volume level of playing sound effects.
     */
    FloatControl volCtrl;

    /**
     * Enum for the volume levels that the SoundManager can play at.
     *
     * @author Sugaku
     */
    public enum Volume {

        /**
         * The loudest volume available.
         */
        HIGH,

        /**
         * Roughly half of the allowed volume.
         */
        MEDIUM,

        /**
         * Around 25% of the volume allowed.
         */
        LOW,

        /**
         * The lowest volume supported. Likely mute.
         */
        MUTE
    }

    /**
     * Creates a new SoundManager for use in a game.
     */
    public SoundManager () {

    }

    /**
     * Plays the given sound effect.
     *
     * @param effect The sound effect to play.
     */
    public void play (SoundEffects effect) {
        play(effect, Volume.MEDIUM);
    }

    /**
     * Plays the given sound effect at the given level.
     *
     * @param effect The sound effect to play.
     * @param volume The volume to play the sound effect at.
     */
    public void play (SoundEffects effect, Volume volume) {
        if (clip != null) if (clip.isOpen()) clip.close();
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream(effect.getPath())));
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.open();
            this.clip = clip;
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
