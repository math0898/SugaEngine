package suga.engine.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import suga.engine.game.objects.AIAgent;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.input.mouse.BasicMouseListener;
import suga.engine.physics.BasicPhysicsEngine;
import suga.engine.input.keyboard.GameKeyListener;
import suga.engine.physics.PhysicsEngine;
import suga.engine.threads.SugaThread;

import java.util.Stack;

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
    GraphicsPanel panel;

    /**
     * Resets the game instance before each unit test runs.
     */
    @BeforeEach
    void setUp () {
        panel = mock(GraphicsPanel.class);
        game = new BasicGame(panel, mock(GameKeyListener.class), mock(BasicMouseListener.class));
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

    /**
     * Loop in the case of BasicGame should call the logic on AIAgents, GameObjects, and check physics for collisions.
     */
    @Test
    void loop () {
        GameObject o1 = mock(GameObject.class);
        GameObject o2 = mock(GameObject.class);
        AIAgent a1 = mock(AIAgent.class);
        AIAgent a2 = mock(AIAgent.class);
        game.physics = mock(BasicPhysicsEngine.class);
        game.addAgent(a1);
        game.addAgent(a2);
        game.addGameObject("o1", o1);
        game.addGameObject("o2", o2);
        verify(o1, times(0)).runLogic();
        verify(o2, times(0)).runLogic();
        verify(a1, times(0)).runLogic();
        verify(a2, times(0)).runLogic();
        verify(game.physics, times(0)).checkCollisions();
        game.loop();
        verify(o1, times(1)).runLogic();
        verify(o2, times(1)).runLogic();
        verify(a1, times(1)).runLogic();
        verify(a2, times(1)).runLogic();
        verify(game.physics, times(1)).checkCollisions();
    }

    /**
     * Process input should read from the mouse and keyboard listeners.
     */
    @Test
    void processInput () {
        when(game.getMouseListener().getEvents()).thenReturn(new Stack<>());
        when(game.keyListener.getKeyPresses()).thenReturn(new Stack<>());
        when(game.keyListener.getKeyReleases()).thenReturn(new Stack<>());
        game.loadedScene = mock(Scene.class);
        game.processInput();
        verify(game.getMouseListener(), times(1)).getEvents();
        verify(game.keyListener, times(1)).getKeyPresses();
        verify(game.keyListener, times(1)).getKeyReleases();
    }

    /**
     * Adding a game object should register it to be called with logic and drawing.
     */
    @Test
    void addGameObject () {
        GameObject o1 = mock(GameObject.class);
        game.addGameObject("o1", o1);
//        verify(game.getPanel(), times(1)).registerListener(o1.getDrawListener());
        assertEquals(o1, game.getGameObject("o1"), "Added object should be present.");
        game.loop();
        verify(o1, times(1)).runLogic();
    }

    /**
     * Should be able to access added games.
     */
    @Test
    void getGameObject () {
        GameObject o1 = mock(GameObject.class);
        game.addGameObject("o1", o1);
        assertEquals(o1, game.getGameObject("o1"), "Should be able to get added object.");
        assertNull(game.getGameObject("not-added"), "Un-added game object should return null.");
    }

    /**
     * Expected to add an agent so that its logic is called each time on loop.
     * May fail depending on whether game.loop() is fully functional.
     */
    @Test
    void addAgent () {
        AIAgent a = mock(AIAgent.class);
        game.loop();
        verify(a, times(0)).runLogic();
        game.addAgent(a);
        game.loop(); // Assuming this is working correctly a.logic() should've been called.
        verify(a, times(1)).runLogic();
    }

    /**
     * Adding a DrawListener to the game should result in it being registered.
     */
    @Test
    void addDrawingListener () {
        /* todo
        Cannot invoke "java.util.Map.containsKey(Object)" because "this.drawingListeners" is null
            java.lang.NullPointerException: Cannot invoke "java.util.Map.containsKey(Object)" because "this.drawingListeners" is null
	        at suga.engine.graphics.GraphicsPanel.registerListener(GraphicsPanel.java:91)
	        at suga.engine.graphics.GraphicsPanel.registerListener(GraphicsPanel.java:81)
	        at suga.engine.game.BasicGame.addDrawingListener(BasicGame.java:218)
         */
//        DrawListener listener = Mockito.mock(DrawListener.class);
//        game.addDrawingListener(listener);
//        verify(panel, times(1)).registerListener(listener);
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
        game.panel = mock(GraphicsPanel.class);
        game.clear();
        assertNull(game.getGameObject("obj"), "Game should no longer contain added object after clear.");
        assertFalse(game.agents.contains(a), "Game should no longer contain added AIAgent after clear.");
        assertNotEquals(physics, game.physics, "Game should have a fresh physics system after clear.");
    }

    /**
     * Loading a scene should call scene.load() once to load everything. Returns false if a scene is not found, or
     * loading fails.
     */
    @Test
    void loadScene () {
        Scene pass = mock(Scene.class);
        when(pass.load(game)).thenReturn(true);
        Scene fail = mock(Scene.class);
        when(fail.load(game)).thenReturn(false);
        game.scenes.put("pass", pass);
        game.scenes.put("fail", fail);
        assertFalse(game.loadScene("Not Found"), "Loading a scene should fail on a scene not present.");
        assertTrue(game.loadScene("pass"), "Loading the scene 'pass' should work, and loadScene() should reflect that.");
        assertFalse(game.loadScene("fail"), "Loading the scene 'fail' shouldn't work, and loadScene() should reflect that.");
    }

    /**
     * Should allow access to the GraphicsPanel being used to draw.
     */
    @Test
    void getPanel () {
        GraphicsPanel a = mock(GraphicsPanel.class);
        GraphicsPanel b = mock(GraphicsPanel.class);
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
        BasicMouseListener a = mock(BasicMouseListener.class);
        BasicMouseListener b = mock(BasicMouseListener.class);
        game.mouseListener = a;
        assertEquals(a, game.getMouseListener(), "Game should return currently active mouse listener.");
        assertNotEquals(b, game.getMouseListener(), "Game should not return an unrelated mouse listener.");
        game.mouseListener = b;
        assertNotEquals(a, game.getMouseListener(), "When game is using a new mouse listener the old should not be equal.");
        assertEquals(b, game.getMouseListener(), "Game should be using updated mouse listener.");
    }
}
