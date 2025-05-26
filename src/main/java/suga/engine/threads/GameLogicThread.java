package suga.engine.threads;

import suga.engine.GameEngine;
import suga.engine.game.Game;

/**
 * A thread used to run game logic once every 1/60th of a second.
 *
 * @author Sugaku
 */
public class GameLogicThread extends AbstractThread implements SugaThread {

    /**
     * The game that should be called once every 1/60th of a second.
     */
    private final Game game;

    /**
     * Creates a new GameLogicThread.
     *
     * @param game The game to run.
     * @param rate How many times the logic should be run per second as a maximum.
     */
    public GameLogicThread (Game game, int rate) {
        super(rate);
        this.game = game;
        game.setThread(this);
    }

    /**
     * Called to run the Game logic thread.
     */
    @Override
    public void run () {
        startTime = System.currentTimeMillis();
        frames = 0;
        while (!stopped) {
            long runtime = 0;
            game.processInput();
            if (!paused) {
                long frameStart = System.currentTimeMillis();
                try {
                    game.loop();
                } catch (Exception e) {
                    GameEngine.getInstance().getLogger().log(e);
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
}
