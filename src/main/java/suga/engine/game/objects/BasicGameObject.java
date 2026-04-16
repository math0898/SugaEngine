package suga.engine.game.objects;

import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.BasicPhysical;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;

import java.util.HashMap;
import java.util.Map;

/**
 * A game object has its own physical position within the world, and a DrawListener to draw it each frame.
 *
 * @author Sugaku
 */
public class BasicGameObject extends BasicPhysical implements DrawListener, GameObject {

    /**
     * Any attributes currently present on this GameObject.
     */
    private final Map<String, Object> attributes = new HashMap<>();

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
    public void runLogic () {

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
     * Adds the given attribute with the given name to this GameObject. This will override any attributes present with
     * the given name.
     *
     * @param attribute The attribute to add to this GameObject.
     * @param name      The name of this attribute.
     */
    @Override
    public void addAttribute (Object attribute, String name) {
        attributes.put(name, attribute);
    }

    /**
     * Removes any attributes with the given name from this GameObject.
     *
     * @param name The name of the attribute to remove.
     */
    @Override
    public void removeAttribute (String name) {
        attributes.remove(name);
    }

    /**
     * Accessor method for attributes on this GameObject. This will preform no null checks nor type checking.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    @Override
    public Object getAttribute (String name) {
        return attributes.get(name);
    }

    /**
     * Accessor method specially for integer attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    @Override
    public Integer getIntAttribute (String name) {
        Object obj = attributes.get(name);
        if (obj == null) return null;
        else if (obj instanceof Integer) return (Integer) obj;
        else return null;
    }

    /**
     * Accessor method specially for string attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    @Override
    public String getStrAttribute (String name) {
        Object obj = attributes.get(name);
        if (obj == null) return null;
        else if (obj instanceof String) return (String) obj;
        else return null;
    }

    /**
     * Accessor method specially for double attributes. This will check typing and return null if the requested
     * attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    @Override
    public Double getDoubleAttribute (String name) {
        Object obj = attributes.get(name);
        if (obj == null) return null;
        else if (obj instanceof Double) return (Double) obj;
        else return null;
    }

    /**
     * Accessor method specially for {@link Vector} attributes. This will check typing and return
     * null if the requested attribute does not match the requested type.
     *
     * @param name The name of the attribute you want to get.
     * @return The requested attribute, or null if not present or type-mismatched.
     */
    @Override
    public Vector getVectorAttribute (String name) {
        Object obj = attributes.get(name);
        if (obj == null) return null;
        else if (obj instanceof Vector) return (Vector) obj;
        else return null;
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
