package suga.engine.physics;

/**
 * Physical objects are objects which contain a velocity, acceleration, and position.
 *
 * @author Sugaku
 */
public interface Physical {

    /**
     * Gets the center position of this collidable object.
     *
     * @return The center position of this collidable object.
     */
    Vector getPos ();

    /**
     * Sets the position of this collidable object.
     *
     * @param pos The new position for this collidable object.
     */
    void setPos (Vector pos);

    /**
     * Gets the current velocity of this physical object.
     *
     * @return The current velocity of this object.
     */
    Vector getVelocity ();

    /**
     * Sets the current velocity of this physical object.
     *
     * @param vel The new velocity for this object.
     */
    void setVelocity (Vector vel);

    /**
     * Gets the current acceleration of this physical object.
     *
     * @return The current acceleration of this object.
     */
    Vector getAcceleration ();

    /**
     * Sets the current acceleration of this physical object.
     *
     * @param accel The new acceleration for this object.
     */
    void setAcceleration (Vector accel);

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    void update ();
}
