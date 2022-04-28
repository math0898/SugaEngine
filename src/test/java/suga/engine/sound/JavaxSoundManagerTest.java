package suga.engine.sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test driven side to developing the SoundManager class.
 */
public class JavaxSoundManagerTest {

    private SoundManager soundManager = new JavaxSoundManager();

    @BeforeEach
    void setup () {
        soundManager = new JavaxSoundManager();
    }
    @Test
    void clearSounds () {
    }

    @Test
    void addSoundEffect () {
    }

    @Test
    void removeSoundEffect () {
    }

    @Test
    void playSoundEffect () {
        soundManager.addSoundEffect("failed-mp3", "/home/sugaku/Music/BladeAndSoul.mp3");
        soundManager.addSoundEffect("failed-not-found", "/home/sugaku/Music/BladeAndSoul.flac");
        assertTrue(soundManager.addSoundEffect("test-effect", "/home/sugaku/Music/BladeAndSoul.wav"));
        soundManager.playSoundEffect("test-effect", 0.1f);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testPlaySoundEffect () {
    }

    @Test
    void addMusicTrack () {
    }

    @Test
    void removeMusicTrack () {
    }

    @Test
    void playMusicTrack () {
    }

    @Test
    void testPlayMusicTrack () {
    }

    @Test
    void stopMusic () {
    }

    @Test
    void addAmbienceEffect () {
    }

    @Test
    void removeAmbienceEffect () {
    }

    @Test
    void ambienceSoundRoll () {
    }
}
