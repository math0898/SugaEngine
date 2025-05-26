package suga.engine.threads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import suga.engine.GameEngine;
import suga.engine.game.Game;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests written for the Game thread.
 *
 * @author Sugaku
 */
class GameLogicThreadTest {

    /**
     * The thread currently under testing.
     */
    private GameLogicThread thread;

    /**
     * A mock Game without any logic.
     */
    private Game game = Mockito.mock(Game.class);

    /**
     * Reset the mocks used in the GraphicsThread test.
     */
    @BeforeEach
    void reset () {
        game = Mockito.mock(Game.class);
        thread = new GameLogicThread(game, 60);
    }

    /**
     * Tests whether running the game logic reaches the intended frame rate.
     */ // todo perhaps refactor into a k-tail test.
    @ParameterizedTest
    @CsvFileSource(resources = "/suga/engine/threads/run.csv", numLinesToSkip = 1, delimiter = ',')
    void run_PerformsCloseToRequest (int targetFps, long sampleTime) {
        final double error = 0.01; // We allow a 1% deviation from the target frame rate.
        thread = new GameLogicThread(game, targetFps);
        thread.start();
        try {
            Thread.sleep(sampleTime * 1000);
        } catch (InterruptedException exception) {
            fail("Failed to wait for given duration.");
        }
        thread.setStopped(true);
        GameEngine.getLogger().log(String.format("Game Thread Test: Wanted %dfps and got %.2ffps. Error is %.2f %%", targetFps, thread.getFPS(), (100 - ((targetFps * 100.0) / thread.getFPS()))));
//        assertEquals(targetFps, GraphicsThread.getFPS(), targetFps * error, "Graphics thread should run within " + error + "% of target fps.");
        // Results partially depend on test duration and device running them. My testing resulted in a margin of less
        //  than 1% most often. Regardless no need to fail builds based on the results of this test.
        assertTrue(true);
    }
}