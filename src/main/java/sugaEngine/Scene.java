package sugaEngine;

/**
 * The Scene object is a collection of objects, AIAgents, and a physics engine. Each game likely has multiple scenes.
 *
 * @author Sugaku
 */
public abstract class Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    public abstract boolean load (Game game);
}
