package suga.engine.threads;

import suga.engine.GameEngine;
import suga.engine.logger.Level;

/**
 * The AbstractThread implements most of the common elements between threads including setters/getters for pausing,
 * frame rate and more.
 *
 * @author Sugaku
 */
public abstract class AbstractThread extends Thread implements SugaThread {

    /**
     * Whether to exit the thread.
     */
    protected boolean stopped = false;

    /**
     * Whether to simulate game logic or not.
     */
    protected boolean paused = false;

    /**
     * The target frame rate for this thread.
     */
    protected int frameRate;

    /**
     * The time that this graphics thread was started. Used in calculating average frame rate.
     */
    protected long startTime = 0;

    /**
     * The number of frames that have been rendered since the thread started.
     */
    protected long frames = 0;


    /**
     * Creates a new thread with the given target rate.
     *
     * @param frameRate The target frequency to draw frames at.
     */
    protected AbstractThread (int frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Sets the target frame rate of this GraphicsThread.
     *
     * @param val The new value for the target frame rate.
     */
    public void setFrameRate (int val) {
        if (val <= 0) {
            GameEngine.getLogger().log(this.getClass().toString().replaceAll(".+\\.", "") + ": " + val + ". Only natural numbers (no zero) allowed.", Level.EXCEPTION);
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
     * Returns the average frame rate while this GraphicsThread has been running.
     *
     * @return The average frame rate of this thread since starting.
     */
    public double getFPS () {
        return (frames * 1.0) / ((System.currentTimeMillis() - startTime) / 1000.0);
    }
}
