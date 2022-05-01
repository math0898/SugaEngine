package suga.engine.physics;

import suga.engine.physics.collidables.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The PhysicsEngine has a list of all the objects currently in the world and checks every logic cycle whether any are
 * currently colliding. If they are they the appropriate method is called.
 *
 * @author Sugaku
 */
public class BasicPhysicsEngine implements PhysicsEngine {

    /**
     * A list of objects that should be called for collision logic.
     */
    protected List<Collidable> collidables = new ArrayList<>();

    /**
     * A list of objects that should have their position and velocity updated.
     */
    protected List<Physical> physicals = new ArrayList<>();

    /**
     * Checks all objects in the list for collisions with other objects. Quite a costly method may require optimization.
     */
    public void checkCollisions () {
        for (int i = 0; i < collidables.size(); i++) {
            Collidable master = collidables.get(i);
            for (int j = i; j < collidables.size(); j++) {
                if (i == j) continue;
                Collidable temp = collidables.get(j); // How many times are collisions called on a single object?
                boolean touching = false;
                boolean colliding = false;
                for (Vector v : temp.getHitBox().getTestPoints()) {
                    if (colliding) break;
                    if (master.getHitBox().isInside(v)) colliding = true;
                    else if (master.getHitBox().touching(v)) touching = true;
                }
                for (Vector v : master.getHitBox().getTestPoints()) {
                    if (colliding) break;
                    if (temp.getHitBox().isInside(v)) colliding = true;
                    else if (temp.getHitBox().touching(v)) touching = true;
                }
                if (colliding) {
                    Collidable mc = master.clone(); // Save values in master.
                    master.collision(temp);
                    temp.collision(mc);
                }
                if (touching && !colliding) {
                    Collidable mc = master.clone(); // Save values in master.
                    master.touch(temp.clone());
                    temp.touch(mc);
                }
            }
        }
    }

    /**
     * Updates the position of all physical objects in the physics engine.
     */
    @Override
    public void update () {
        physicals.forEach(Physical::update);
    }

    /**
     * Adds a physical object to the list of objects to be checked for their movement logic ran.
     *
     * @param object The physical object to be added to the list.
     */
    @Override
    public void addPhysical (Physical object) {
        physicals.add(object);
    }

    /**
     * Adds a collidable object to the list of objects to be checked for collisions.
     *
     * @param object The collidable object to be added to the list.
     */
    @Override
    public void addCollidable (Collidable object) {
        collidables.add(object);
    }

    /**
     * Adds a new object to the Physics Engine.
     *
     * @param object The object to add to the physics engine.
     */
    public void addObject (Collidable object) {
        collidables.add(object);
        physicals.add(object);
    }
}