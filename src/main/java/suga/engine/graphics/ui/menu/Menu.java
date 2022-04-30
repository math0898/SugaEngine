package suga.engine.graphics.ui.menu;

import suga.engine.graphics.DrawListener;
import suga.engine.input.keyboard.KeyValue;

/**
 * A menu is an object used by the player to select something, or modify the value of something. It always contains
 * multiple options and has an option currently hovered which can be 'selected'.
 *
 * @author Sugaku
 */
public interface Menu extends DrawListener {

    /**
     * Selects the currently hovered menu option and takes any actions that should be taken.
     */
    void select ();

    /**
     * Moves to another menu option based on the given key input.
     *
     * @param key The key that was pressed.
     */
    void move (KeyValue key);

    /**
     * Checks the position of the mouse to determine which option to highlight.
     */
    void checkMouse ();
}
