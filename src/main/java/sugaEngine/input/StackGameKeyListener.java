package sugaEngine.input;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

/**
 * The StackGameKeyListener creates a stack of pressed, and depressed events which are then accessed with accessor
 * methods to be read by the game.
 *
 * @author Sugaku
 */
public class StackGameKeyListener implements KeyListener {

    /**
     * A stack of keys that have been pressed and need to be handled by the game.
     */
    protected Stack<Integer> keysPressed = new Stack<>();

    /**
     * A stack of keys that have been depressed and need to be handled by the game.
     */
    protected Stack<Integer> keysDepressed = new Stack<>();

    /**
     * Creates a new StackGameKeyListener for use in a game.
     *
     * @param frame The JFrame that this KeyListener is using.
     */
    public StackGameKeyListener (JFrame frame) {
        frame.addKeyListener(this);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped (KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed (KeyEvent e) {
        keysPressed.add(e.getKeyCode());
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased (KeyEvent e) {
        keysDepressed.add(e.getKeyCode());
    }

    /**
     * Accessor method for the stack of keys that has been pressed. Should be used by games to read key presses.
     *
     * @return The stack of keys that have been pressed.
     */
    public Stack<Integer> getKeysPressed () {
        return keysPressed;
    }

    /**
     * Accessor method for the stack of keys that have been depressed. Should be used by games to read key presses.
     *
     * @return The stack of keys that have been depressed.
     */
    public Stack<Integer> getKeysDepressed () {
        return keysDepressed;
    }
}
