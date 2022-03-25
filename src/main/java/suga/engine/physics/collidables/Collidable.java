package suga.engine.physics.collidables;

import suga.engine.physics.Physical;
import suga.engine.physics.hitboxes.HitBox;

/**
 * An object that can have collisions with other collidable objects.
 *
 * @author Sugaku
 */
public interface Collidable extends Physical {

    /**
     * Gets the HitBox currently being used by this collidable object.
     *
     * @return The hit box being used by this collidable object.
     */
    HitBox getHitBox ();

    /**
     * Assigns the given HitBox to this collidable object. Will likely result in the modification of HitBox location.
     *
     * @param hitBox The new HitBox to assign to this Collidable object.
     */
    void setHitBox (HitBox hitBox);

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    void collision (Collidable obj);

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    void touch (Collidable obj);
}
