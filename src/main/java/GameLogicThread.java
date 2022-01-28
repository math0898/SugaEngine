
/**
 * A thread used to run game logic once every 1/60th of a second.
 *
 * @author Sugaku
 */
public class GameLogicThread extends Thread {

    /**
     * The game that should be called once every 1/60th of a second.
     */
    private final Game game;

    /**
     * A constant on how fast game logic should be called.
     */
    private final int LOGIC_RATE;

    /**
     * Whether to exit the thread.
     */
    private boolean stopped = false; // todo add method to modify.

    /**
     * Whether to simulate game logic or not.
     */
    private boolean paused = false;

    /**
     * The last time that the logic running finished.
     */
    private long lastFinished;

    /**
     * Creates a new GameLogicThread.
     *
     * @param game The game to run.
     * @param rate How many times the logic should be run per second as a maximum.
     */
    public GameLogicThread (Game game, int rate) {
        this.game = game;
        LOGIC_RATE = rate;
    }

    /**
     * Sets whether the logic thread is paused or not.
     *
     * @param val Whether the logic thread should be paused or not.
     */
    public void setPaused (boolean val) {
        paused = val;
    }

    /**
     * Called to run the Game logic thread.
     */
    @Override
    public void run () {
        while (!stopped) {
            while (!paused) {
                if (System.currentTimeMillis() - lastFinished < (1000 / LOGIC_RATE)) {
                    try {
                        //noinspection BusyWait
                        Thread.sleep((1000 / LOGIC_RATE) - (System.currentTimeMillis() - lastFinished));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                lastFinished = System.currentTimeMillis();
                game.loop();
            }
        }
    }
}
