package sugaEngine;

import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.physics.Collidable;
import sugaEngine.physics.Vector;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public abstract class GameObject extends Collidable implements DrawListener {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param immutable Whether this object moves during collisions or not.
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public GameObject (boolean immutable, double width, double height) {
        super(immutable, width, height);
    }

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
