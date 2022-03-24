package sugaEngine.game;

import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanelInterface;
import sugaEngine.input.GameMouseListener;
import sugaEngine.threads.SugaThread;

/**
 * Games require a main game loop to run along with game components that need to be run every game cycle.
 *
 * @author Sugaku
 */
// todo rename to Game in v2.1.1
public interface GameInterface {

    /**
     * Sets the thread that is calling loop() on this Game.
     *
     * @param thread The thread that will be calling loop() on this object.
     */
    void setThread (SugaThread thread);

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
     * Attempts to load the given scene. If successful with return true, if un-found or loading fails, will return
     * false.
     *
     * @param name The name of the scene to attempt loading.
     */
    boolean loadScene (String name);

    /**
     * Accessor method for the graphics panel used by the server.
     *
     * @return The panel used by the server.
     */
    GraphicsPanelInterface getPanel ();

    /**
     * Accessor method for the mouse listener used by the server.
     *
     * @return The mouse listener used by the server.
     */
    GameMouseListener getMouseListener ();
}
