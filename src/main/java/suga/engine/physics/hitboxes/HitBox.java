package suga.engine.physics.hitboxes;

import suga.engine.physics.Vector;

import java.util.Collection;

/**
 * Every collidable object needs a HitBox which defines when collisions occur.
 *
 * @author Sugaku
 */
public interface HitBox {

    /**
     * Returns a collection of test points for this hit box.
     *
     * @return A collection of test points to be used in collision detection.
     */
    Collection<Vector> getTestPoints ();
}
