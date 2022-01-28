package game;

import game.graphics.flat.DrawListener;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public abstract class GameObject implements DrawListener {

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    public abstract void runLogic ();
}
