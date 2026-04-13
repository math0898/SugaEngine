package suga.engine.game.objects;

import suga.engine.graphics.DrawListener;
import suga.engine.physics.Vector;
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

    /**
     * Adds the given attribute with the given name to this GameObject. This will override any attributes present with
     * the given name.
     *
     * @param attribute The attribute to add to this GameObject.
     * @param name The name of this attribute.
     */
    void addAttribute (Object attribute, String name);

    /**
     * Removes any attributes with the given name from this GameObject.
     *
     * @param name The name of the attribute to remove.
     */
    void removeAttribute (String name);

    /**
     * Accessor method for attributes on this GameObject. This will preform no null checks nor type checking.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present.
     */
    Object getAttribute (String name);

    /**
     * Accessor method specially for integer attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    int getIntAttribute (String name);

    /**
     * Accessor method specially for string attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    String getStrAttribute (String name);

    /**
     * Accessor method specially for double attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    double getDoubleAttribute (String name);

    /**
     * Accessor method specially for {@link suga.engine.physics.Vector} attributes. This will check typing and return
     * null if the requested attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    Vector getVectorAttribute (String name);
}
