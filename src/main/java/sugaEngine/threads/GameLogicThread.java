package sugaEngine.threads;

import sugaEngine.Game;

/**
 * A thread used to run game logic once every 1/60th of a second.
 *
 * @author Sugaku
 */
public class GameLogicThread extends SugaThread {

    /**
     * The game that should be called once every 1/60th of a second.
     */
    private final Game game;

    /**
     * A constant on how fast game logic should be called.
     */
    private final int LOGIC_RATE;

    /**
     * Creates a new GameLogicThread.
     *
     * @param game The game to run.
     * @param rate How many times the logic should be run per second as a maximum.
     */
    public GameLogicThread (Game game, int rate) {
        this.game = game;
        LOGIC_RATE = rate;
        game.setThread(this);
    }

    /**
     * Called to run the Game logic thread.
     */
    @Override
    public void run () {
        long lastFinished = 0;
        while (!stopped) {
            long logicTime = System.currentTimeMillis() - lastFinished;
            if (logicTime < (1000 / LOGIC_RATE)) {
                try {
                    //noinspection BusyWait
                    Thread.sleep((1000 / LOGIC_RATE) - logicTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lastFinished = System.currentTimeMillis();
            game.processInput();
            if (!paused) game.loop();
        }
    }
}
