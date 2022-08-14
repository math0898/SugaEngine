package suga.engine.physics;

/**
 * A simple implementation of the Physical interface which can be used to cut down on development time.
 *
 * @author Sugaku
 */
public class BasicPhysical implements Physical {

    /**
     * The position of this Physical object.
     */
    protected Vector pos;

    /**
     * The velocity of this Physical object.
     */
    protected Vector vel;

    /**
     * The acceleration of this Physical object.
     */
    protected Vector accel;

    /**
     * The mass of this Physical object.
     */
    protected double mass;

    /**
     * Creates a new BasicPhysical object.
     *
     * @param pos   The position to start this object at.
     * @param vel   The initial velocity of this object.
     * @param accel The acceleration of this object.
     * @param mass  The mass of this object.
     */
    public BasicPhysical (Vector pos, Vector vel, Vector accel, double mass) {
        this.pos = pos;
        this.vel = vel;
        this.accel = accel;
        this.mass = mass;
    }

    /**
     * Gets the center position of this collidable object. Modifying this position object will modify the position of
     * the object.
     *
     * @return The center position of this collidable object.
     */
    @Override
    public Vector getPos () {
        return pos;
    }

    /**
     * Sets the position of this collidable object. Modifying the position object after passing it will modify the
     * position of the object.
     *
     * @param pos The new position for this collidable object.
     */
    @Override
    public void setPos (Vector pos) {
        this.pos = pos;
    }

    /**
     * Gets the current velocity of this physical object. Modifying this velocity object will modify the velocity of the
     * object.
     *
     * @return The current velocity of this object.
     */
    @Override
    public Vector getVelocity () {
        return vel;
    }

    /**
     * Sets the current velocity of this physical object. Modifying the velocity object after passing it will modify the
     * velocity of the object.
     *
     * @param vel The new velocity for this object.
     */
    @Override
    public void setVelocity (Vector vel) {
        this.vel = vel;
    }

    /**
     * Gets the current acceleration of this physical object. Modifying this acceleration object will modify the
     * acceleration of the object.
     *
     * @return The current acceleration of this object.
     */
    @Override
    public Vector getAcceleration () {
        return accel;
    }

    /**
     * Sets the current acceleration of this physical object. Modifying the acceleration object after passing it will
     * modify the acceleration of the object.
     *
     * @param accel The new acceleration for this object.
     */
    @Override
    public void setAcceleration (Vector accel) {
        this.accel = accel;
    }

    /**
     * Accessor method for the mass of this object. Mass numbers larger than int max should be considered unmovable.
     *
     * @return The mass of this object.
     */
    @Override
    public double getMass () {
        return mass;
    }

    /**
     * Sets the mass of this object.
     *
     * @param mass The new mass of this object.
     */
    @Override
    public void setMass (double mass) {
        this.mass = mass;
    }

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    @Override
    public void update () {
        pos.add(vel);
        vel.add(accel);
    }
}
