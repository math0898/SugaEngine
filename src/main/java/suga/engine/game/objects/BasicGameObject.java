package suga.engine.game.objects;

import suga.engine.graphics.GraphicsPanel;
import suga.engine.graphics.DrawListener;
import suga.engine.physics.BasicPhysical;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public class BasicGameObject extends BasicPhysical implements DrawListener, GameObject {

    /**
     * Creates a new BasicGameObject with zero vectors and a mass of 1.
     */
    public BasicGameObject () {
        this(Vector.ZERO.clone(), Vector.ZERO.clone(), Vector.ZERO.clone(), 1);
    }

    /**
     * Creates a new BasicGameObject with the given vel, acceleration, position, and mass.
     *
     * @param pos   The position to start this object at.
     * @param vel   The initial velocity of this object.
     * @param accel The acceleration of this object.
     * @param mass  The mass of this object.
     */
    public BasicGameObject (Vector pos, Vector vel, Vector accel, double mass) {
        super(pos, vel, accel, mass);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Deprecated // Physics engine will update object positions now using Physical.update();
    public void runLogic () {
//        pos.add(velocity);
//        if (velocity.magnitude() < 25 && accel.magnitude() > 0 || velocity.magnitude() > 25 && accel.magnitude() < 0) velocity.add(accel);
    }

    /**
     * Attaches a DrawListener to this GameObject.
     *
     * @param listener The DrawListener to attach to this GameObject.
     */
    @Override
    public void setDrawListener (DrawListener listener) {

    }

    /**
     * If present, returns the DrawListener associated with this GameObject. May be null.
     *
     * @return Either the DrawListener attached to this GameObject or null.
     */
    @Override
    public DrawListener getDrawListener () {
        return this;
    }

    /**
     * Assigns a collider to this GameObject.
     *
     * @param collider The collider to assign to this GameObject.
     */
    @Override
    public void setCollider (Collidable collider) {

    }

    /**
     * Gets a collider that is present on this object. If none are present returns null.
     *
     * @return Either the Collider attached to this GameObject or null.
     */
    @Override
    public Collidable getCollider () {
        return null;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {

    }
}
