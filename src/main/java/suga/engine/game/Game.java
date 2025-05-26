package suga.engine.game;

import suga.engine.game.objects.AIAgent;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.input.keyboard.GameKeyListener;
import suga.engine.input.mouse.GameMouseListener;
import suga.engine.threads.SugaThread;

/**
 * Games require a main game loop to run along with game components that need to be run every game cycle.
 *
 * @author Sugaku
 */
public interface Game {

    /**
     * Sets the thread that is calling loop() on this Game.
     *
     * @param thread The thread that will be calling loop() on this object.
     */
    void setThread (SugaThread thread);

    /**
     * Sets the graphics panel being used by this game.
     *
     * @param panel The panel to assign to this game.
     */
    void setPanel (GraphicsPanel panel);

    /**
     * Sets the key listener currently being used by this game.
     *
     * @param listener The new key listener that this game should use.
     */
    void setKeyListener (GameKeyListener listener);

    /**
     * Sets the mouse listener currently being used by this game.
     *
     * @param listener The new mouse listener that this game should use.
     */
    void setMouseListener (GameMouseListener listener);

    /**
     * Accessor method for the thread that is calling loop(). This can be used to determine whether the game has stopped
     * or paused.
     *
     * @return The thread that is running this game instance.
     */
    SugaThread getThread ();

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    void loop ();

    /**
     * Processes inputs given by players. Is run during pause.
     */
    void processInput ();

    /**
     * Adds a GameObject by the given name.
     *
     * @param name The name of the game object. Can be used later to remove the item.
     * @param object The game object to add.
     */
    void addGameObject (String name, GameObject object);

    /**
     * Accessor method for game objects.
     *
     * @param name The name of the object to attempt to get.
     * @return The found object or null.
     */
    GameObject getGameObject (String name);

    /**
     * Registers a new AI agent so that it can be called every tick after collisions but before object logic.
     *
     * @param agent The AIAgent to add into the list of agents.
     */
    void addAgent (AIAgent agent);

    /**
     * Registers a new DrawingListener. This will not register anything beyond the draw method. Usually used by UI,
     * hence the name.
     *
     * @param listener The draw listener that should be registered to this panel.
     */
    void addDrawingListener (DrawListener listener);

    /**
     * Clears all AIAgents, physics managers, GameObjects, and PanelListeners.
     */
    void clear ();

    /**
     * Attempts to load the starting scene for this game. If successful will return true, if un-found or loading fails,
     * will return false.
     *
     * @return True on a successful first scene load.
     */
    boolean loadStartScene ();

    /**
     * Attempts to load the given scene. If successful with return true, if un-found or loading fails, will return
     * false.
     *
     * @param name The name of the scene to attempt loading.
     * @return True on a successful scene load.
     */
    boolean loadScene (String name);

    /**
     * Accessor method for the graphics panel used by the server.
     *
     * @return The panel used by the server.
     */
    GraphicsPanel getPanel ();

    /**
     * Accessor method for the mouse listener used by the server.
     *
     * @return The mouse listener used by the server.
     */
    GameMouseListener getMouseListener ();
}
