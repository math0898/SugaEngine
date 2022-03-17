package sugaEngine.input;

/**
 * The default KeyMapper works by creating an array the size of the maximally supported keycode value and storing the
 * resulting enum values at each keycode index.
 *
 * @author Sugaku
 */
public class DefaultKeyMapper implements KeyMapper {

    /**
     * The array used to convert between keycodes and keys.
     */
    protected KeyValues[] values = new KeyValues[256];

    /**
     * Constructs the DefaultKeyMapper. Initializes everything to null before iterating through the values of KeyValues.
     */
    public DefaultKeyMapper () {
        for (int i = 0; i < 255; i++)
            values[i] = null;
        for (KeyValues v : KeyValues.values())
            values[v.getValue()] = v;
    }

    /**
     * Converts the given keycode into a KeyValue.
     *
     * @param keycode The keycode to convert into a value.
     * @return The enum value of the given key.
     */
    @Override
    public KeyValues convert (int keycode) {
        return values[keycode];
    }

    /**
     * Sets the given keycode to the given enum value. Will replace the current result from that keycode.
     *
     * @param keycode The keycode to change the mapping of.
     * @param key     The new key to map that keycode to.
     */
    @Override
    public void set (int keycode, KeyValues key) {
        if (keycode < 0 || keycode > 255) throw new IllegalArgumentException("Keycode not supported [0,255]: " + keycode);
        values[keycode] = key;
    }
}
