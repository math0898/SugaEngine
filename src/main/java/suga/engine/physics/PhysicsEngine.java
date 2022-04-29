package suga.engine.physics;

import suga.engine.physics.collidables.Collidable;

/**
 * The PhysicsEngine has a list of all the objects currently in the world and checks every logic cycle whether any are
 * currently colliding. If they are they the appropriate method is called.
 *
 * @author Sugaku
 */
public interface PhysicsEngine {

    /**
     * Checks all objects in the list for collisions with other objects. Quite a costly method may require optimization.
     */
    void checkCollisions ();

    /**
     * Updates the position of all physical objects in the physics engine.
     */
    void update ();

    /**
     * Adds a physical object to the list of objects to be checked for their movement logic ran.
     *
     * @param object The physical object to be added to the list.
     */
    void addPhysical (Physical object);

    /**
     * Adds a collidable object to the list of objects to be checked for collisions.
     *
     * @param object The collidable object to be added to the list.
     */
    void addCollidable (Collidable object);

    /**
     * Adds a collidable object which is also a physical object to the list of objects to be checked for collisions and
     * have their movement logic ran.
     *
     * @param object The collidable, physical object to be added to the list.
     */
    void addObject (Collidable object);
}
