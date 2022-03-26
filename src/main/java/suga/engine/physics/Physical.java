package suga.engine.physics;

/**
 * Physical objects are objects which contain a velocity, acceleration, position, and mass. The mass can be larger than
 * integer max to indicate the object is non-movable.
 *
 * @author Sugaku
 */
public interface Physical {

    /**
     * Gets the center position of this collidable object. Modifying this position object will modify the position of
     * the object.
     *
     * @return The center position of this collidable object.
     */
    Vector getPos ();

    /**
     * Sets the position of this collidable object. Modifying the position object after passing it will modify the
     * position of the object.
     *
     * @param pos The new position for this collidable object.
     */
    void setPos (Vector pos);

    /**
     * Gets the current velocity of this physical object. Modifying this velocity object will modify the velocity of the
     * object.
     *
     * @return The current velocity of this object.
     */
    Vector getVelocity ();

    /**
     * Sets the current velocity of this physical object. Modifying the velocity object after passing it will modify the
     * velocity of the object.
     *
     * @param vel The new velocity for this object.
     */
    void setVelocity (Vector vel);

    /**
     * Gets the current acceleration of this physical object. Modifying this acceleration object will modify the
     * acceleration of the object.
     *
     * @return The current acceleration of this object.
     */
    Vector getAcceleration ();

    /**
     * Sets the current acceleration of this physical object. Modifying the acceleration object after passing it will
     * modify the acceleration of the object.
     *
     * @param accel The new acceleration for this object.
     */
    void setAcceleration (Vector accel);

    /**
     * Accessor method for the mass of this object. Mass numbers larger than int max should be considered unmovable.
     *
     * @return The mass of this object.
     */
    double getMass ();

    /**
     * Sets the mass of this object.
     *
     * @param mass The new mass of this object.
     */
    void setMass (double mass);

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    void update ();
}
