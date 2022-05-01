package suga.engine.input.keyboard;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.Stack;

/**
 * The GameKeyListenerInterface is an object that responds whenever a key is pressed
 */
public interface GameKeyListener extends KeyListener {

    /**
     * Overrides the currently used KeyMapper with a new KeyMapper.
     *
     * @param mapping The new mapping to apply to this key listener.
     */
    void setKeyMapping (KeyMapper mapping);

    /**
     * Accessor method for the currently used KeyMapper. Helpful for modifying mappings.
     *
     * @return The KeyMapper instance being used by this KeyMapper.
     */
    KeyMapper getKeyMapping ();

    /**
     * Checks whether the given key is currently being held or not.
     *
     * @param key The key to check if it's being held or not.
     * @return True if the key is currently being held, otherwise false.
     */
    boolean isHeld (KeyValue key);

    /**
     * Returns a stack of key presses that have not yet been handled.
     *
     * @return The 'to handle' stack of key presses.
     */
    Stack<KeyValue> getKeyPresses ();

    /**
     * Returns a stack of key releases that have not yet been handled.
     *
     * @return The 'to handle' stack of key releases.
     */
    Stack<KeyValue> getKeyReleases ();

    /**
     * Sets the frame that this key listener is listening to. Does not deregister with the old frame.
     *
     * @param frame The new frame to listen to.
     */
    void setFrame (JFrame frame);
}
