import javax.swing.*;

/**
 * A thread used to refresh the graphics of a panel as fast as possible.
 *
 * @author Sugaku
 */
public class GraphicsThread extends Thread {

    /**
     * The panel that should be redrawn every frame.
     */
    private final JPanel panel;

    /**
     * Whether to exit the thread.
     */
    private boolean stop = false;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel The panel to refresh for every frame.
     */
    public GraphicsThread (JPanel panel) {
        this.panel = panel;
    }

    /**
     * Sets whether the graphics thread is stopped or not.
     *
     * @param val Whether the graphics thread should be stopped.
     */
    public void setStopped (boolean val) {
        stop = val;
    }

    /**
     * Called to run the Graphics thread.
     */
    @Override
    public void run () {
        while (!stop) panel.repaint();
    }
}
