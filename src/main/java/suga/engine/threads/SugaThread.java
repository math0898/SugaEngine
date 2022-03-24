package suga.engine.threads;

/**
 * A SugaThread is no different from a normal thread except that it has built in pause and stop values. These can be set
 * by calling the appropriate methods.
 *
 * @author Sugaku
 */
public abstract class SugaThread extends Thread implements ThreadInterface {

    /**
     * Whether to exit the thread.
     */
    protected boolean stopped = false;

    /**
     * Whether to simulate game logic or not.
     */
    protected boolean paused = false;

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
}
