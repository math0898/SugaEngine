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
    ESC(27),

    /**
     * The left key maps to keycode 37.
     */
    ARROW_LEFT(37),

    /**
     * The up key maps to keycode 38.
     */
    ARROW_UP(38),

    /**
     * The right key maps to keycode 39.
     */
    ARROW_RIGHT(39),

    /**
     * The down key maps to keycode 40.
     */
    ARROW_DOWN(40),

    /**
     * The 'a' key maps to keycode 65.
     */
    A(65),

    /**
     * The 'd' key maps to keycode 68.
     */
    D(68),

    /**
     * The 'l' key maps to keycode 76.
     */
    L(76),

    /**
     * The 's' key maps to keycode 83.
     */
    S(83),

    /**
     * The 'w' key maps to keycode 87.
     */
    W(87);

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
