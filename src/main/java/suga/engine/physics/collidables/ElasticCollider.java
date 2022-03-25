package suga.engine.physics.collidables;

import suga.engine.physics.Vector;
import suga.engine.physics.hitboxes.HitBox;

/**
 * An ElasticCollider is a collider which results in perfectly elastic collisions.
 *
 * @author Sugaku
 */
public class ElasticCollider implements Collidable { // todo implement.

    /**
     * The current position of this ElasticCollider.
     */
    protected Vector pos;

    /**
     * The current velocity of this ElasticCollider.
     */
    protected Vector velocity;

    /**
     * Gets the center position of this collidable object.
     *
     * @return The center position of this collidable object.
     */
    @Override
    public Vector getPos () {
        return pos;
    }

    /**
     * Sets the position of this collidable object.
     *
     * @param pos The new position for this collidable object.
     */
    @Override
    public void setPos (Vector pos) {
        this.pos = pos;
    }

    /**
     * Gets the current velocity of this physical object.
     *
     * @return The current velocity of this object.
     */
    @Override
    public Vector getVelocity () {
        return velocity;
    }

    /**
     * Sets the current velocity of this physical object.
     *
     * @param vel The new velocity for this object.
     */
    @Override
    public void setVelocity (Vector vel) {
        velocity = vel;
    }

    /**
     * Gets the current acceleration of this physical object.
     *
     * @return The current acceleration of this object.
     */
    @Override
    public Vector getAcceleration () {
        return null;
    }

    /**
     * Sets the current acceleration of this physical object.
     *
     * @param accel The new acceleration for this object.
     */
    @Override
    public void setAcceleration (Vector accel) {

    }

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    @Override
    public void update () {

    }

    /**
     * Gets the HitBox currently being used by this collidable object.
     *
     * @return The hit box being used by this collidable object.
     */
    @Override
    public HitBox getHitBox () {
        return null;
    }

    /**
     * Assigns the given HitBox to this collidable object. Will likely result in the modification of HitBox location.
     *
     * @param hitBox The new HitBox to assign to this Collidable object.
     */
    @Override
    public void setHitBox (HitBox hitBox) {

    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (Collidable obj) {

    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (Collidable obj) {

    }
}
