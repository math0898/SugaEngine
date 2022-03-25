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
    protected List<Collidable> objects = new ArrayList<>();

    /**
     * Checks all objects in the list for collisions with other objects. Quite a costly method may require optimization.
     */
    public void checkCollisions () {
        for (int i = 0; i < objects.size(); i++) {
            Collidable master = objects.get(i);
            for (int j = i; j < objects.size(); j++) {
                if (i == j) continue;
                Collidable temp = objects.get(j);
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
                    master.collision(temp);
                    temp.collision(master);
                }
                if (touching) {
                    master.touch(temp);
                    temp.touch(master);
                }
            }
        }
    }

    /**
     * Adds a new object to the Physics Engine.
     *
     * @param object The object to add to the physics engine.
     */
    public void addObject (Collidable object) {
        objects.add(object);
    }
}
