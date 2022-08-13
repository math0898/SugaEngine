package suga.engine.physics.hitboxes;

import suga.engine.graphics.GraphicsPanelInterface;
import suga.engine.physics.Vector;

import java.util.Collection;

/**
 * Every collidable object needs a HitBox which defines when collisions occur.
 *
 * @author Sugaku
 */
public interface HitBox {

    /**
     * Gets the center position of this hit box.
     *
     * @return The center position of the hit box.
     */
    Vector getPos ();

    /**
     * Sets the center position of this hit box. Used to center hit boxes on game objects.
     *
     * @param pos The new center position of this hit box.
     */
    void setPos (Vector pos);

    /**
     * Returns a collection of test points for this hit box.
     *
     * @return A collection of test points to be used in collision detection.
     */
    Collection<Vector> getTestPoints ();

    /**
     * Tests whether the given point is within this hit box or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is inside this hit box.
     */
    boolean isInside (Vector test);

    /**
     * Tests whether the given point is touching this hit box or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is on the boundary of this hit box.
     */
    boolean touching (Vector test);

    /**
     * Draws this hit box to the given graphics panel. Different hit boxes may appear differently when drawn.
     *
     * @param panel The panel to draw the hit box test points to.
     */
    void drawHitBox (GraphicsPanelInterface panel);
}
