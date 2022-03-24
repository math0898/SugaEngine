package suga.engine.game.objects;

/**
 * AIAgents are bits of logic that effect a single object in the game.
 *
 * @author Sugaku
 */
public abstract class AbstractAIAgent {

    /**
     * The GameObject that this agent has control over.
     */
    protected final AbstractGameObject object;

    /**
     * Creates a new AIAgent with control over the given object.
     *
     * @param object The GameObject that this AIAgent has control over.
     */
    public AbstractAIAgent (AbstractGameObject object) {
        this.object = object;
    }

    /**
     * Runs the logic of the AIAgent.
     */
    public abstract void logic ();
}
