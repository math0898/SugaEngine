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
    public void runLogic () {
        pos.add(velocity);
        velocity.add(accel);
    }

    /**
     * Accessor method for the position vector of the game object.
     *
     * @return The position vector.
     */
    public Vector getPos () {
        return pos;
    }

    /**
     * Accessor method for the velocity vector of the game object.
     *
     * @return The velocity vector.
     */
    public Vector getVelocity () {
        return velocity;
    }

    /**
     * Accessor method for the acceleration vector of the game object.
     *
     * @return The acceleration vector.
     */
    public Vector getAccel() {
        return accel;
    }
}
