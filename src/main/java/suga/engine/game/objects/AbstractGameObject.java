package suga.engine.game.objects;

import suga.engine.graphics.AbstractGraphicsPanel;
import suga.engine.graphics.DrawListener;
import suga.engine.physics.Physical;
import suga.engine.physics.Vector;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
@Deprecated // todo Remove references, implement.
public class AbstractGameObject implements DrawListener, Physical {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *.
     */
    public AbstractGameObject () {
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
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, AbstractGraphicsPanel panel) {

    }

    /**
     * Gets the center position of this collidable object. Modifying this position object will modify the position of
     * the object.
     *
     * @return The center position of this collidable object.
     */
    @Override
    public Vector getPos () {
        return null;
    }

    /**
     * Sets the position of this collidable object. Modifying the position object after passing it will modify the
     * position of the object.
     *
     * @param pos The new position for this collidable object.
     */
    @Override
    public void setPos (Vector pos) {

    }

    /**
     * Gets the current velocity of this physical object. Modifying this velocity object will modify the velocity of the
     * object.
     *
     * @return The current velocity of this object.
     */
    @Override
    public Vector getVelocity () {
        return null;
    }

    /**
     * Sets the current velocity of this physical object. Modifying the velocity object after passing it will modify the
     * velocity of the object.
     *
     * @param vel The new velocity for this object.
     */
    @Override
    public void setVelocity (Vector vel) {

    }

    /**
     * Gets the current acceleration of this physical object. Modifying this acceleration object will modify the
     * acceleration of the object.
     *
     * @return The current acceleration of this object.
     */
    @Override
    public Vector getAcceleration () {
        return null;
    }

    /**
     * Sets the current acceleration of this physical object. Modifying the acceleration object after passing it will
     * modify the acceleration of the object.
     *
     * @param accel The new acceleration for this object.
     */
    @Override
    public void setAcceleration (Vector accel) {

    }

    /**
     * Accessor method for the mass of this object. Mass numbers larger than int max should be considered unmovable.
     *
     * @return The mass of this object.
     */
    @Override
    public double getMass () {
        return 0;
    }

    /**
     * Sets the mass of this object.
     *
     * @param mass The new mass of this object.
     */
    @Override
    public void setMass (double mass) {

    }

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    @Override
    public void update () {

    }
}
