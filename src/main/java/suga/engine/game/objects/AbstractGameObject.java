package suga.engine.game.objects;

import suga.engine.graphics.DrawListener;
import suga.engine.physics.collidables.ElasticCollider;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public abstract class AbstractGameObject extends ElasticCollider implements DrawListener {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param immutable Whether this object moves during collisions or not.
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public AbstractGameObject (boolean immutable, double width, double height) {
//        super(immutable, width, height);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Deprecated // Physics engine will update object positions now using Physical.update();
    public void runLogic () {
//        pos.add(velocity);
//        if (velocity.magnitude() < 25 && accel.magnitude() > 0 || velocity.magnitude() > 25 && accel.magnitude() < 0) velocity.add(accel);
    }
}
