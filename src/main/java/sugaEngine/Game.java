package sugaEngine;

import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.PhysicsEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Games require a main game loop to run along with game components that need to be run every game cycle.
 *
 * @author Sugaku
 */
public abstract class Game {

    /**
     * A list of game objects for this game. Their logic should be called every cycle.
     */
    protected Map<String, GameObject> objects = new HashMap<>();

    /**
     * The physics engine that will be used with this game.
     */
    protected PhysicsEngine physics = new PhysicsEngine();

    /**
     * A list of AIAgents that should have their logic run every cycle.
     */
    protected List<AIAgent> agents = new ArrayList<>();

    /**
     * A Map of scenes indexed by name.
     */
    protected Map<String, Scene> scenes = new HashMap<>();

    /**
     * The currently loaded scene object.
     */
    protected Scene loadedScene;

    /**
     * The graphics panel that should be used to register draw listeners to.
     */
    protected GraphicsPanel panel;

    /**
     * The key listener that is being used by this game.
     */
    protected GameKeyListener keyListener;

    /**
     * The mouse listener that is being used by this game.
     */
    protected GameMouseListener mouseListener;

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public Game (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        this.panel = panel;
        keyListener = listener;
        this.mouseListener = mouseListener;
    }

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    public void loop () {
        physics.checkCollisions();
        for (AIAgent a : agents) a.logic();
        for (GameObject gO : objects.values()) gO.runLogic();
    }

    /**
     * Processes inputs given by players. Is run during pause.
     */
    public abstract void processInput ();

    /**
     * Adds a GameObject by the given name.
     *
     * @param name The name of the game object. Can be used later to remove the item.
     * @param object The game object to add.
     */
    public void addGameObject (String name, GameObject object) {
        objects.put(name, object);
        panel.registerListener(object);
        physics.addObject(object);
    }

    /**
     * Registers a new AI agent so that it can be called every tick after collisions but before object logic.
     *
     * @param agent The AIAgent to add into the list of agents.
     */
    public void addAgent (AIAgent agent) {
        agents.add(agent);
    }

    /**
     * Clears all AIAgents, physics managers, GameObjects, and PanelListeners.
     */
    public void clear () {
        physics = new PhysicsEngine();
        agents = new ArrayList<>();
        objects = new HashMap<>();
        panel.clearListeners();
    }

    /**
     * Attempts to load the given scene. If successful with return true, if un-found or loading fails, will return
     * false.
     *
     * @param name The name of the scene to attempt loading.
     */
    public boolean loadScene (String name) {
        Scene scene = scenes.get(name);
        if (scene == null) return false;
        if (scene.load(this)) {
            loadedScene = scene;
            return true;
        }
        return false;
    }
}
