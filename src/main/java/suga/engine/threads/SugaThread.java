package suga.engine.threads;

/**
 * A thread in the SugaEngine is no different from a normal thread except that it has built in pause and stop values.
 * These can be set by calling the appropriate methods.
 *
 * @author Sugaku
 */
public interface SugaThread extends Runnable {

    /**
     * Sets whether the thread is paused or not.
     *
     * @param val Whether the thread should be paused or not.
     */
    void setPaused (boolean val);

    /**
     * Accessor method for the current status of the thread.
     *
     * @return Whether the thread is paused currently or not.
     */
    boolean getPaused ();

    /**
     * Sets whether the thread is stopped or not.
     *
     * @param val Whether the thread should be stopped.
     */
    void setStopped (boolean val);

    /**
     * Accessor method for the current status of the thread.
     *
     * @return Whether this thread has been stopped or not.
     */
    boolean getStopped ();
}
