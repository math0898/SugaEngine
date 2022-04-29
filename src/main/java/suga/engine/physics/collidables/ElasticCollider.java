package suga.engine.physics.collidables;

import suga.engine.physics.Vector;
import suga.engine.physics.hitboxes.HitBox;

/**
 * An ElasticCollider is a collider which results in perfectly elastic collisions.
 *
 * @author Sugaku
 */
public class ElasticCollider implements Collidable {

    /**
     * The mass of this ElasticCollider.
     */
    protected double mass;

    /**
     * The current position of this ElasticCollider.
     */
    protected Vector pos;

    /**
     * The current velocity of this ElasticCollider.
     */
    protected Vector velocity;

    /**
     * The current acceleration of ElasticCollider.
     */
    protected Vector acceleration;

    /**
     * The current HitBox of this ElasticCollider.
     */
    protected HitBox hitBox;

    /**
     * Creates a new ElasticCollider with the given position, velocity, acceleration, mass, and HitBox.
     *
     * @param pos The position of this ElasticCollider.
     * @param vel The velocity of this ElasticCollider.
     * @param accel The acceleration of this ElasticCollider.
     * @param mass The mass of this ElasticCollider.
     * @param hitBox The hitBox that should be used by this ElasticCollider.
     */
    public ElasticCollider (Vector pos, Vector vel, Vector accel, double mass, HitBox hitBox) {
        this.pos = pos.clone();
        this.velocity = vel.clone();
        this.acceleration = accel.clone();
        this.mass = mass;
        this.hitBox = hitBox;
    }

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
        return acceleration;
    }

    /**
     * Sets the current acceleration of this physical object.
     *
     * @param accel The new acceleration for this object.
     */
    @Override
    public void setAcceleration (Vector accel) {
        acceleration = accel;
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
        pos.add(velocity);
        velocity.add(acceleration);
    }

    /**
     * Gets the HitBox currently being used by this collidable object.
     *
     * @return The hit box being used by this collidable object.
     */
    @Override
    public HitBox getHitBox () {
        return hitBox;
    }

    /**
     * Assigns the given HitBox to this collidable object. Will likely result in the modification of HitBox location.
     *
     * @param hitBox The new HitBox to assign to this Collidable object.
     */
    @Override
    public void setHitBox (HitBox hitBox) {
        this.hitBox = hitBox;
        hitBox.setPos(pos); // Sync positions.
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (Collidable obj) {
        touch(obj);
    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (Collidable obj) {
        if (obj.getMass() < Integer.MAX_VALUE) {
            Vector v = obj.getVelocity();
            velocity.setX((obj.getMass() * v.getX() * v.getX()) / (mass * v.getX() <= 0 ? -1 : 1));
            velocity.setY((obj.getMass() * v.getY() * v.getY()) / (mass * v.getY() <= 0 ? -1 : 1));
            velocity.setZ((obj.getMass() * v.getZ() * v.getZ()) / (mass * v.getZ() <= 0 ? -1 : 1));
        } else velocity.scale(-1);
    }

    /**
     * Returns a deep copy of this collidable object. Used to preserve values of velocity, position, and acceleration
     * during collision calculations.
     *
     * @return A copy of this object with the same position, velocity, and acceleration.
     */
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public ElasticCollider clone () {
        return new ElasticCollider(pos, velocity, acceleration, mass, hitBox);
    }

    /**
     * Two ElasticColliders are equal if the fields are the same.
     *
     * @param obj The object to check if it is equal to 'this'.
     * @return True if and only if the two objects are equivalent. Two objects are equivalent if field values are the
     *         same even if they don't share objects.
     */
    @Override
    public boolean equals (Object obj) {
        if (obj instanceof ElasticCollider collider) {
            if (pos != null) {
                if (!pos.equals(collider.pos)) return false;
            } else if (collider.pos != null) return false;
            if (velocity != null) {
                if (!velocity.equals(collider.velocity)) return false;
            } else if (collider.velocity != null) return false;
            if (acceleration != null) {
                if (!acceleration.equals(collider.acceleration)) return false;
            } else if (collider.acceleration != null) return false;
            if (mass != collider.mass) return false;
            if (hitBox != null) return hitBox.equals(collider.hitBox);
            else return collider.hitBox == null;
        } else return false;
    }
}
