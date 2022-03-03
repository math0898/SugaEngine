package sugaEngine.sound;

import javax.sound.sampled.*;
import java.util.Objects;

/**
 * The SoundManager class is used to play sound to the player.
 *
 * @author Sugaku
 */
public class SoundManager {

    /**
     * The audio line being used by this SoundManager.
     */
    Port lineOut;

    /**
     * The volume control for the audio line being used by this SoundManager.
     */
    FloatControl volCtrl;

    /**
     * Creates a new SoundManager. Attempts to get a lineOut from the AudioSystem which has volume control.
     *
     * @throws LineUnavailableException Exception thrown when a line out cannot be found.
     */
    public SoundManager () throws LineUnavailableException {
//        Mixer mixer = AudioSystem.getMixer(null);
//        lineOut = (Port) mixer.getLine(Port.Info.LINE_IN);
//        lineOut.open();
//        volCtrl = (FloatControl) lineOut.getControl(FloatControl.Type.VOLUME);
    }

    /**
     * Plays the audio resource at the given location.
     *
     * @param path The path to the audio clip resource.
     */
    public void play (String path) {
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream(path))));
            clip.start();
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception ignored) {
            System.out.println(ignored.toString());
        }
//        System.out.println("Line controls!");
//        for (Control c : lineOut.getControls()) System.out.println(c.toString());
    }

//    /**
//     * A list of clips that are currently being played by the SoundManager.
//     */
//    private Clip clip;
//
//    /**
//     * Control for the volume level of playing sound effects.
//     */
//    FloatControl volCtrl;
//
//    /**
//     * Enum for the volume levels that the SoundManager can play at.
//     *
//     * @author Sugaku
//     */
//    public enum Volume {
//
//        /**
//         * The loudest volume available.
//         */
//        HIGH,
//
//        /**
//         * Roughly half of the allowed volume.
//         */
//        MEDIUM,
//
//        /**
//         * Around 25% of the volume allowed.
//         */
//        LOW,
//
//        /**
//         * The lowest volume supported. Likely mute.
//         */
//        MUTE
//    }
//
//
//    /**
//     * Plays the given sound effect.
//     *
//     * @param effect The sound effect to play.
//     */
//    public void play (SoundEffects effect) {
//        play(effect, Volume.MEDIUM);
//    }
//
//    /**
//     * Plays the given sound effect at the given level.
//     *
//     * @param effect The sound effect to play.
//     * @param volume The volume to play the sound effect at.
//     */
//    public void play (SoundEffects effect, Volume volume) {
//        if (clip != null) if (clip.isOpen()) clip.close();
//        try {
//            AudioInputStream stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream(effect.getPath())));
//            Clip clip = AudioSystem.getClip();
//            clip.open(stream);
//            clip.open();
//            this.clip = clip;
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
