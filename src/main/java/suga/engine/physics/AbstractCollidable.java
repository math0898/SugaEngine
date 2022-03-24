package suga.engine.physics;

import suga.engine.physics.hitboxes.SquareHitBox;

/**
 * An object that can have collisions with other collidable objects.
 *
 * @author Sugaku
 */
public abstract class AbstractCollidable extends SquareHitBox implements Collidable {

    /**
     * Whether this object is allowed to move or if it's velocity is locked at zero.
     */
    protected boolean immutable;

    /**
     * The current velocity of the game object.
     */
    protected Vector velocity = new Vector(0, 0, 0);

    /**
     * The current acceleration of the game object.
     */
    protected Vector accel = new Vector(0,0,0);

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param immutable Whether this object moves during collisions or not.
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public AbstractCollidable(boolean immutable, double width, double height) {
        super(width, height);
        this.immutable = immutable;
    }


    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    public abstract void collision (SquareHitBox obj);

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    public abstract void touch (SquareHitBox obj);

    /**
     * Returns the name of this object for use during collisions.
     *
     * @return The name of this object.
     */
    public abstract String getName ();
}
