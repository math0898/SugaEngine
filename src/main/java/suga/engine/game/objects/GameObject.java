package suga.engine.game.objects;

import suga.engine.graphics.DrawListener;
import suga.engine.physics.collidables.Collidable;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public interface GameObject {

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    void runLogic ();

    /**
     * Attaches a DrawListener to this GameObject.
     *
     * @param listener The DrawListener to attach to this GameObject.
     */
    void setDrawListener (DrawListener listener);

    /**
     * If present, returns the DrawListener associated with this GameObject. May be null.
     *
     * @return Either the DrawListener attached to this GameObject or null.
     */
    DrawListener getDrawListener ();

    /**
     * Assigns a collider to this GameObject.
     *
     * @param collider The collider to assign to this GameObject.
     */
    void setCollider (Collidable collider);

    /**
     * Gets a collider that is present on this object. If none are present returns null.
     *
     * @return Either the Collider attached to this GameObject or null.
     */
    Collidable getCollider ();
}
