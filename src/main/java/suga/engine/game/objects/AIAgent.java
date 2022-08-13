package suga.engine.game.objects;

/**
 * AIAgents are bits of logic that effect a single object in the game.
 *
 * @author Sugaku
 */
public interface AIAgent {

    /**
     * Called every logic frame to run the logic for this AIAgent.
     */
    void runLogic ();
}
