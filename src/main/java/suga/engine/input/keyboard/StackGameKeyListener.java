package suga.engine.input.keyboard;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * The StackGameKeyListener creates a stack of pressed, and depressed events which are then accessed with accessor
 * methods to be read by the game.
 *
 * @author Sugaku
 */
public class StackGameKeyListener implements GameKeyListener {

    /**
     * The KeyMapper being used by this listener.
     */
    protected KeyMapper mapper;

    /**
     * A collection of keys that are currently being held.
     */
    protected Collection<KeyValue> heldKeys = new ArrayList<>();

    /**
     * A stack of keys that have been pressed and need to be handled by the game.
     */
    protected Stack<KeyValue> keysPressed = new Stack<>();

    /**
     * A stack of keys that have been depressed and need to be handled by the game.
     */
    protected Stack<KeyValue> keysReleased = new Stack<>();

    /**
     * Creates a new StackGameKeyListener without binding it to a frame. Uses the BasicKeyMapper by default.
     */
    public StackGameKeyListener () {
        this(new BasicKeyMapper());
    }

    /**
     * Creates a new StackGameKeyListener without binding it to a frame.
     *
     * @param mapper The KeyMapper to be used by this KeyListener.
     */
    public StackGameKeyListener (BasicKeyMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Creates a new StackGameKeyListener for use in the given frame. Uses the BasicKeyMapper by default.
     *
     * @param frame The JFrame that this KeyListener is using.
     */
    public StackGameKeyListener (JFrame frame) {
        this(frame, new BasicKeyMapper());
    }

    /**
     * Creates a new StackGameKeyListener for use in the given frame.
     *
     * @param frame  The JFrame that this KeyListener is using.
     * @param mapper The KeyMapper to be used by this KeyListener.
     */
    public StackGameKeyListener (JFrame frame, KeyMapper mapper) {
        frame.addKeyListener(this);
        this.mapper = mapper;
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
        KeyValue key = mapper.convert(e.getKeyCode());
        if (heldKeys.contains(key)) return;
        keysPressed.add(key);
        heldKeys.add(key);
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
        KeyValue key = mapper.convert(e.getKeyCode());
        if (!heldKeys.contains(key)) return;
        keysReleased.add(key);
        heldKeys.remove(key);
    }

    /**
     * Accessor method for the stack of keys that has been pressed. Should be used by games to read key presses.
     *
     * @return The stack of keys that have been pressed.
     */
    @Deprecated // Remove v2.*.*
    public Stack<Integer> getKeysPressed () {
        Stack<Integer> s = new Stack<>();
        for (KeyValue k : keysPressed) s.add(k.getValue());
        return s;
    }

    /**
     * Accessor method for the stack of keys that have been depressed. Should be used by games to read key presses.
     *
     * @return The stack of keys that have been depressed.
     */
    @Deprecated // Remove v2.*.*
    public Stack<Integer> getKeysDepressed () {
        Stack<Integer> s = new Stack<>();
        for (KeyValue k : keysReleased) s.add(k.getValue());
        return s;
    }

    /**
     * Overrides the currently used KeyMapper with a new KeyMapper.
     *
     * @param mapping The new mapping to apply to this key listener.
     */
    @Override
    public void setKeyMapping (KeyMapper mapping) {
        mapper = mapping;
    }

    /**
     * Accessor method for the currently used KeyMapper. Helpful for modifying mappings.
     *
     * @return The KeyMapper instance being used by this KeyMapper.
     */
    @Override
    public KeyMapper getKeyMapping () {
        return mapper;
    }

    /**
     * Checks whether the given key is currently being held or not.
     *
     * @param key The key to check if it's being held or not.
     * @return True if the key is currently being held, otherwise false.
     */
    @Override
    public boolean isHeld (KeyValue key) {
        return heldKeys.contains(key);
    }

    /**
     * Returns a stack of key presses that have not yet been handled.
     *
     * @return The 'to handle' stack of key presses.
     */
    @Override
    public Stack<KeyValue> getKeyPresses () {
        return keysPressed;
    }

    /**
     * Returns a stack of key releases that have not yet been handled.
     *
     * @return The 'to handle' stack of key releases.
     */
    @Override
    public Stack<KeyValue> getKeyReleases () {
        return keysReleased;
    }

    /**
     * Sets the frame that this key listener is listening to. Does not deregister with the old frame.
     *
     * @param frame The new frame to listen to.
     */
    public void setFrame (JFrame frame) {
        frame.addKeyListener(this);
    }
}
