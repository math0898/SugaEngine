package sugaEngine.input;

/**
 * The key mapper is used to map keys between their keycodes and the KeyValues enum.
 *
 * @author Sugaku
 */
public interface KeyMapper {

    /**
     * Converts the given keycode into a KeyValue.
     *
     * @param keycode The keycode to convert into a value.
     * @return The enum value of the given key.
     */
    KeyValues convert (int keycode);

    /**
     * Sets the given keycode to the given enum value. Will replace the current result from that keycode.
     *
     * @param keycode The keycode to change the mapping of.
     * @param key     The new key to map that keycode to.
     */
    void set (int keycode, KeyValues key);
}
