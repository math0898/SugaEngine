import javax.swing.*;

/**
 * A thread used to refresh the graphics of a panel once every 1/60th of a second.
 *
 * @author Sugaku
 */
public class GraphicsThread extends Thread {

    /**
     *
     */
    private final JPanel panel;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel The panel to refresh for every frame.
     */
    public GraphicsThread (JPanel panel) {
        this.panel = panel;
    }

    /**
     * Called to run the Graphics thread.
     */
    @Override
    public void run () {
        while (!false) { // todo add stop condition.
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!false) { // todo add pause condition.
                panel.repaint();
            }
        }
    }
}
