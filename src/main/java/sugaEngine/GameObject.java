package sugaEngine;

import sugaEngine.graphics.flat.DrawListener;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public abstract class GameObject implements DrawListener {

    /**
     * The current position of the game object.
     */
    protected Vector pos;

    /**
     * The current velocity of the game object.
     */
    protected Vector velocity;

    /**
     * The current acceleration of the game object.
     */
    protected Vector accel;

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    public abstract void runLogic (); // todo run pos, vel, accel equations at this level.
}
