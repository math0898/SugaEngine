package suga.engine.input.keyboard;

/**
 * Gives an enum value to the different key values.
 * Thank you to @see <a href="https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list">StackOverflow</a>
 * for listing all these key codes.
 *
 * @author Sugaku
 */
public enum KeyValue {

    /**
     * The cancel key maps to keycode 3.
     */
    CANCEL(3),

    /**
     * The backspace key maps to keycode 8.
     */
    BACKSPACE(8),

    /**
     * The tab key maps to keycode 9.
     */
    TAB(9),

    /**
     * The enter key maps to keycode 10.
     */
    ENTER(10),

    /**
     * The clear key maps to keycode 12.
     */
    CLEAR(12),

    /**
     * The shift key maps to keycode 16.
     */
    SHIFT(16),

    /**
     * The ctrl key maps to keycode 17.
     */
    CTRL(17),

    /**
     * The alt key maps to keycode 18.
     */
    ALT(18),

    /**
     * The pause key maps to keycode 19.
     */
    PAUSE(19),

    /**
     * The caps lock key maps to keycode 20.
     */
    CAPS_LOCK(20),

    /**
     * The escape key maps to keycode 27.
     */
    ESC(27),

    /**
     * The space key maps to keycode 32.
     */
    SPACE(32),

    /**
     * The page up key maps to keycode 33.
     */
    PAGE_UP(33),

    /**
     * The page down key maps to keycode 34.
     */
    PAGE_DOWN(34),

    /**
     * The end key maps to keycode 35.
     */
    END(35),

    /**
     * The home key maps to keycode 36.
     */
    HOME(36),

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
     * The 0 key maps to keycode 48.
     */
    NUM_0(48),

    /**
     * The 1 key maps to keycode 49.
     */
    NUM_1(49),

    /**
     * The 2 key maps to keycode 50.
     */
    NUM_2(50),

    /**
     * The 3 key maps to keycode 51.
     */
    NUM_3(51),

    /**
     * The 4 key maps to keycode 52.
     */
    NUM_4(52),

    /**
     * The 5 key maps to keycode 53.
     */
    NUM_5(53),

    /**
     * The 6 key maps to keycode 54.
     */
    NUM_6(54),

    /**
     * The 7 key maps to keycode 55.
     */
    NUM_7(55),

    /**
     * The 8 key maps to keycode 56.
     */
    NUM_8(56),

    /**
     * The 9 key maps to keycode 57.
     */
    NUM_9(57),

    /**
     * The comma key maps to keycode 44.
     */
    COMMA(44),

    /**
     * The minus key maps to keycode 45.
     */
    MINUS(45),

    /**
     * The period key maps to keycode 46.
     */
    PERIOD(46),

    /**
     * The slash key maps to keycode 47.
     */
    SLASH(47),

    /**
     * The 'A' maps to keycode 65.
     */
    A(65),

    /**
     * The 'B' maps to keycode 66.
     */
    B(66),

    /**
     * The 'C' maps to keycode 67.
     */
    C(67),

    /**
     * The 'D' maps to keycode 68.
     */
    D(68),

    /**
     * The 'E' maps to keycode 69.
     */
    E(69),

    /**
     * The 'F' maps to keycode 70.
     */
    F(70),

    /**
     * The 'G' maps to keycode 71.
     */
    G(71),

    /**
     * The 'H' maps to keycode 72.
     */
    H(72),

    /**
     * The 'I' maps to keycode 73.
     */
    I(73),

    /**
     * The 'J' maps to keycode 74.
     */
    J(74),

    /**
     * The 'K' maps to keycode 75.
     */
    K(75),

    /**
     * The 'L' maps to keycode 76.
     */
    L(76),

    /**
     * The 'M' maps to keycode 77.
     */
    M(77),

    /**
     * The 'N' maps to keycode 78.
     */
    N(78),

    /**
     * The 'O' maps to keycode 79.
     */
    O(79),

    /**
     * The 'P' maps to keycode 80.
     */
    P(80),

    /**
     * The 'Q' maps to keycode 81.
     */
    Q(81),

    /**
     * The 'R' maps to keycode 82.
     */
    R(82),

    /**
     * The 'S' maps to keycode 83.
     */
    S(83),

    /**
     * The 'T' maps to keycode 84.
     */
    T(84),

    /**
     * The 'U' maps to keycode 85.
     */
    U(85),

    /**
     * The 'V' maps to keycode 86.
     */
    V(86),

    /**
     * The 'W' maps to keycode 87.
     */
    W(87),

    /**
     * The 'X' maps to keycode 88.
     */
    X(88),

    /**
     * The 'Y' maps to keycode 89.
     */
    Y(89),

    /**
     * The 'Z' maps to keycode 90.
     */
    Z(90);

    /**
     * The integer value of the integer value.
     */
    private final int value;

    /**
     * Creates a new KeyValue with the given value.
     *
     * @param value The value to assign to this key.
     */
    KeyValue (int value) {
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

    /**
     * Converts the given int keycode into an enum value from KeyValues.
     *
     * @param code The code of the key pressed.
     * @return The enum value of the key if present, otherwise null.
     */
    public static KeyValue toEnum (int code) { // Might be a bit slow for input handling. Perhaps prioritize more popular keys.
        for (KeyValue k : KeyValue.values())  //  This would also be a good level for key remapping.
            if (k.getValue() == code)
                return k;
        return null;
    }
}
