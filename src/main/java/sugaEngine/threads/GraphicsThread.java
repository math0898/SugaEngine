package sugaEngine.threads;

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
     * The last time that the graphics running finished.
     */
    private long lastFinished;

    /**
     * The time that this graphics thread was started. Used in calculating average frame rate.
     */
    private static long startTime = 0;

    /**
     * The number of frames that have been rendered since the thread started.
     */
    private static long frames = 0;

    /**
     * The target frame rate for this GraphicsThread.
     */
    private final int FRAME_RATE;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel The panel to refresh for every frame.
     */
    public GraphicsThread (JPanel panel, int frameRate) {
        this.panel = panel;
        FRAME_RATE = frameRate;
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
        startTime = System.currentTimeMillis();
        while (!stop) {
            if (System.currentTimeMillis() - lastFinished < (1000 / FRAME_RATE)) {
                try {
                    //noinspection BusyWait
                    Thread.sleep((int) ((1000 / FRAME_RATE) - (System.currentTimeMillis() - lastFinished)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lastFinished = System.currentTimeMillis();
            panel.repaint();
            frames++;
        }
    }

    /**
     * Returns the average frame rate while this GraphicsThread has been running.
     *
     * @return The average frame rate of this thread since starting.
     */
    public static double getFPS () {
        return (frames * 1.0) / ((System.currentTimeMillis() - startTime) / 1000.0);
    }
}
