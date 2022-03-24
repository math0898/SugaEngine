package sugaEngine.sound;

//import org.lwjgl.openal.*;

/**
 * The SoundManager class is used to play sound to the player.
 *
 * @author Sugaku
 */
public class SoundManager {

    /**
     *
     */
    int alSource;

    /**
     *
     */
    int alSampleSet;

    /**
     * The context being used by this SoundManager.
     */
    long context;

    /**
     * The ALC device being used by this SoundManager.
     */
    long device;

    /**
     * Creates a new SoundManager. Attempts to get a lineOut from the AudioSystem which has volume control.
     */
    public SoundManager () {
        /* Essentially C++ code follows. Abandon hope all yee who tread here with Java notions. */
//        ALCapabilities capabilities = AL.getCapabilities();
//        AL.setCurrentThread(capabilities);
//        device = ALC11.alcOpenDevice(ByteBuffer.allocateDirect(ALC11.ALC_DEFAULT_DEVICE_SPECIFIER));
//        context = ALC11.alcCreateContext(device, (int[]) null);
//        ALC11.alcMakeContextCurrent(context);
    }

    /**
     * Plays the audio resource at the given location.
     *
     * @param path The path to the audio clip resource.
     */
    public void play (String path) {
//        try {
//            alSource = AL11.alGenSources();
//            alSampleSet = AL11.alGenBuffers();
//            byte[] alBuffer = Objects.requireNonNull(this.getClass().getResourceAsStream(path)).readAllBytes();
//            AL11.alBufferData(alSampleSet, AL10.AL_FORMAT_STEREO8, ByteBuffer.wrap(alBuffer), AL11.AL_FREQUENCY);
//            AL11.alSourcei(alSource, AL10.AL_BUFFER, alSampleSet);
//            AL11.alSourcei(alSource, AL10.AL_LOOPING, AL10.AL_TRUE);
//            AL11.alSourcePlay(alSource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
