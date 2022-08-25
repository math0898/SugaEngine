package suga.engine.threads;

import suga.engine.GameEngine;
import suga.engine.graphics.GraphicsPanelInterface;
import suga.engine.logger.Level;

/**
 * A thread used to refresh the graphics of a panel as fast as possible.
 *
 * @author Sugaku
 */
public class GraphicsThread extends Thread implements SugaThread {

    /**
     * Whether to exit the thread.
     */
    protected boolean stopped = false;

    /**
     * Whether to simulate game logic or not.
     */
    protected boolean paused = false;

    /**
     * The panel that should be redrawn every frame.
     */
    private final GraphicsPanelInterface panel;

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
    private int frameRate;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel     The panel to refresh for every frame.
     * @param frameRate The target frequency to draw frames at.
     */
    public GraphicsThread (GraphicsPanelInterface panel, int frameRate) {
        this.panel = panel;
        this.frameRate = frameRate;
        panel.setThread(this);
    }

    /**
     * Sets the target frame rate of this GraphicsThread.
     *
     * @param val The new value for the target frame rate.
     */
    public void setFrameRate (int val) {
        if (val <= 0) {
            GameEngine.getLogger().log("GraphicsThread: Attempted to change target frame rate to " + val + ". Only natural numbers (no zero) allowed.", Level.EXCEPTION);
            return;
        }
        this.frameRate = val;
    }

    /**
     * Accessor method for the current target frame rate of the thread.
     *
     * @return The current target thread refresh rate.
     */
    public int getFrameRate () {
        return frameRate;
    }

    /**
     * Sets whether the thread is paused or not.
     *
     * @param val Whether the thread should be paused or not.
     */
    public void setPaused (boolean val) {
        paused = val;
    }

    /**
     * Accessor method for the current status of the thread.
     *
     * @return Whether the thread is paused currently or not.
     */
    public boolean getPaused () {
        return paused;
    }

    /**
     * Sets whether the thread is stopped or not.
     *
     * @param val Whether the thread should be stopped.
     */
    public void setStopped (boolean val) {
        stopped = val;
    }

    /**
     * Accessor method for the current status of the thread.
     *
     * @return Whether this thread has been stopped or not.
     */
    public boolean getStopped () {
        return stopped;
    }

    /**
     * Called to run the Graphics thread.
     */
    @Override
    public void run () {
        startTime = System.currentTimeMillis();
        frames = 0;
        while (!stopped) {
            long runtime = 0;
            if (!paused) {
                long frameStart = System.currentTimeMillis();
                try {
                    panel.repaint();
                } catch (Exception e) {
                    GameEngine.getLogger().log(e);
                }
                runtime = System.currentTimeMillis() - frameStart;
            }
            try {
                long toWait = Math.round(((1000.0 - ((System.currentTimeMillis() - startTime) % 1000)) / (frameRate - (frames % frameRate) )) - runtime);
                if (toWait < 0) toWait = 0;
                //noinspection BusyWait
                sleep(toWait);
            } catch (InterruptedException e) {
                GameEngine.getLogger().log(e);
            }
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
