package sugaEngine.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanelInterface;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.physics.PhysicsEngine;
import sugaEngine.threads.SugaThread;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * UnitTests for the abstract Game class.
 *
 * @author Sugaku
 */
class BasicGameTest {

    /**
     * The game instance being used in each test.
     */
    private BasicGame game;

    /**
     * An instance of the graphics panel which is used for testing.
     */
    GraphicsPanelInterface panel;

    /**
     * Resets the game instance before each unit test runs.
     */
    @BeforeEach
    void setUp () {
        panel = mock(GraphicsPanelInterface.class);
        game = new BasicGame(panel, mock(GameKeyListener.class), mock(GameMouseListener.class));
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
        fail();
    }

    @Test
    void processInput () {
        fail();
    }

    @Test
    void addGameObject () {
        fail();
    }

    @Test
    void getGameObject () {
        fail();
    }

    /**
     * Expected to add an agent so that its logic is called each time on loop.
     *
     * May fail depending on whether game.loop() is fully functional.
     */
    @Test
    void addAgent () {
        AIAgent a = mock(AIAgent.class);
        game.loop();
        verify(a, times(0)).logic();
        game.addAgent(a);
        game.loop(); // Assuming this is working correctly a.logic() should've been called.
        verify(a, times(1)).logic();
    }

    /**
     * Adding a DrawListener to the game should result in it being registered.
     */
    @Test
    void addDrawingListener () {
        DrawListener listener = Mockito.mock(DrawListener.class);
        game.addDrawingListener(listener);
        verify(panel, times(1)).registerListener(listener);
    }

    /**
     * After calling clear all GameObjects, AIAgents, Physics objects, and DrawListeners.
     */
    @Test
    void clear () {
        PhysicsEngine physics = game.physics;
        GameObject o = mock(GameObject.class);
        game.addGameObject("obj", o);
        AIAgent a = mock(AIAgent.class);
        game.addAgent(a);
        GraphicsPanelInterface p = mock(GraphicsPanelInterface.class);
        game.panel = p;
        game.clear();
        verify(p, times(1)).clearListeners();
        assertNull(game.getGameObject("obj"), "Game should no longer contain added object after clear.");
        assertFalse(game.agents.contains(a), "Game should no longer contain added AIAgent after clear.");
        assertNotEquals(physics, game.physics, "Game should have a fresh physics system after clear.");
    }

    @Test
    void loadScene () {
        fail();
    }

    /**
     * Should allow access to the GraphicsPanel being used to draw.
     */
    @Test
    void getPanel () {
        GraphicsPanelInterface a = mock(GraphicsPanelInterface.class);
        GraphicsPanelInterface b = mock(GraphicsPanelInterface.class);
        game.panel = a;
        assertEquals(a, game.getPanel(), "Game should return currently active panel.");
        assertNotEquals(b, game.getPanel(), "Game should not return an unrelated panel.");
        game.panel = b;
        assertNotEquals(a, game.getPanel(), "When game is using a new panel the old should not be equal.");
        assertEquals(b, game.getPanel(), "Game should be using updated panel.");
    }

    /**
     * Should allow access to the MouseListener being used by this game.
     */
    @Test
    void getMouseListener () {
        GameMouseListener a = mock(GameMouseListener.class);
        GameMouseListener b = mock(GameMouseListener.class);
        game.mouseListener = a;
        assertEquals(a, game.getMouseListener(), "Game should return currently active mouse listener.");
        assertNotEquals(b, game.getMouseListener(), "Game should not return an unrelated mouse listener.");
        game.mouseListener = b;
        assertNotEquals(a, game.getMouseListener(), "When game is using a new mouse listener the old should not be equal.");
        assertEquals(b, game.getMouseListener(), "Game should be using updated mouse listener.");
    }
}
