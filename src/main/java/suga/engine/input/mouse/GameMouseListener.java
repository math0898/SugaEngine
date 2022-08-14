package suga.engine.input.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

/**
 * A GameMouseListener is an extension of the MouseListener which includes an active position, attached frame, and
 * getEvents() method.
 *
 * @author Sugaku
 */
public interface GameMouseListener extends MouseListener {

    /**
     * Returns the current position of the mouse.
     *
     * @return A point object which contains data about the current mouse position.
     */
    Point getMousePos ();

    /**
     * Sets the frame that this mouse listener is listening to. Does not deregister with the old frame.
     *
     * @param frame The new frame to listen to.
     */
    void setFrame (JFrame frame);

    /**
     * Accessor method for the stack of mouse events that need to be handled.
     *
     * @return The stack of mouse events.
     */
    Stack<MouseEvent> getEvents ();
}
