package sugaEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class GameMouseListener implements MouseListener {

    /**
     * A reference to the JFrame object that this GameMouseListener is listening to.
     */
    protected final JFrame frame;

    /**
     * A stack of mouse click events that need to be processed.
     */
    protected Stack<MouseEvent> events = new Stack<>();

    /**
     * Creates a new GameMouseListener with the given JFrame so that the mouse position can be grabbed at any point.
     *
     * @param frame The JFrame instance that this mouse listener should be listening to.
     */
    public GameMouseListener (JFrame frame) {
        this.frame = frame;
        frame.addMouseListener(this);
    }

    /**
     * Returns the current position of the mouse.
     *
     * @return A point object which contains data about the current mouse position.
     */
    public Point getMousePos () {
        return frame.getMousePosition();
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked (MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed (MouseEvent e) {
        events.add(e);
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased (MouseEvent e) {
        events.add(e);
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered (MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited (MouseEvent e) {

    }

    /**
     * Accessor method for the stack of mouse events that need to be handled.
     *
     * @return The stack of mouse events.
     */
    public Stack<MouseEvent> getEvents () {
        return events;
    }
}
