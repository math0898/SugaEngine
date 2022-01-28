package sugaEngine;

/**
 * Gives an enum value to the different key values.
 *
 * @author Sugaku
 */
public enum KeyValues {

    /**
     * The escape key maps to keycode 27.
     */
    ESC(27);

    /**
     * The integer value of the integer value.
     */
    private final int value;

    /**
     * Creates a new KeyValue with the given value.
     *
     * @param value The value to assign to this key.
     */
    KeyValues (int value) {
        this.value = value;
    }

    /**
     * Returns the value of the key.
     *
     * @return The value associated with the key.
     */
    public int getValue () {
        return value;
    }
}
