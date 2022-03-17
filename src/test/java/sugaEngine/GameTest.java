package sugaEngine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.threads.SugaThread;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * UnitTests for the abstract Game class.
 *
 * @author Sugaku
 */
class GameTest { // todo: Implement unit tests.

    /**
     * The game instance being used in each test.
     */
    private Game game;

    /**
     * Resets the game instance before each unit test runs.
     */
    @BeforeEach
    void setUp () {
        game = new Game(mock(GraphicsPanel.class), mock(GameKeyListener.class), mock(GameMouseListener.class)) {};
    }

    /**
     * Tests the setThread() method on Game. Expected behavior is that setting a thread will overwrite the current thread.
     */
    @Test
    void setThread () {
        SugaThread t1 = mock(SugaThread.class);
        SugaThread t2 = mock(SugaThread.class);
        game.setThread(null);
        assertNull(game.thread, "Game has been assigned null as a thread.");
        game.setThread(t1);
        assertNotNull(game.thread, "Game has been given a thread... the retrieved thread should not be null.");
        assertEquals(t1, game.thread, "Game should have the thread given to it.");
        game.setThread(t2);
        assertNotEquals(t1, game.thread, "Game should not have old thread when given a new one.");
        assertEquals(t2, game.thread, "Game should have the newly set thread.");
    }

    /**
     * Tests the getThread() method on Game. Expected behavior is that the set thread will be returned.
     */
    @Test
    void getThread () {
        SugaThread t1 = mock(SugaThread.class);
        SugaThread t2 = mock(SugaThread.class);
        assertNull(game.getThread(), "Game has not been assigned a thread and should return null.");
        game.thread = t1;
        assertEquals(t1, game.getThread(), "getThread() should return the currently set thread.");
        assertNotEquals(t2, game.getThread(), "getThread() should not return an object equal to the one set.");
        game.thread = t2;
        assertEquals(t2, game.getThread(), "getThread() should return the currently set thread.");
        assertNotEquals(t1, game.getThread(), "getThread() should not return an object equal to the one set.");
    }

    @Test
    void loop () {
    }

    @Test
    void processInput () {
    }

    @Test
    void addGameObject () {
    }

    @Test
    void getGameObject () {
    }

    @Test
    void addAgent () {
    }

    @Test
    void addDrawingListener () {
    }

    @Test
    void clear () {
    }

    @Test
    void loadScene () {
    }

    @Test
    void getPanel () {
    }

    @Test
    void getMouseListener () {
    }
}
