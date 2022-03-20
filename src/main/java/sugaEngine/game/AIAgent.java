package sugaEngine.game;

/**
 * AIAgents are bits of logic that effect a single object in the game.
 *
 * @author Sugaku
 */
public abstract class AIAgent {

    /**
     * The GameObject that this agent has control over.
     */
    protected final GameObject object;

    /**
     * Creates a new AIAgent with control over the given object.
     *
     * @param object The GameObject that this AIAgent has control over.
     */
    public AIAgent (GameObject object) {
        this.object = object;
    }

    /**
     * Runs the logic of the AIAgent.
     */
    public abstract void logic ();
}
