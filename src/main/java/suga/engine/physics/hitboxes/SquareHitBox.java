package suga.engine.physics.hitboxes;

import suga.engine.graphics.GraphicsPanelInterface;
import suga.engine.physics.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Every collidable object needs a HitBox. This is a box where if a test point overlaps with a box then a collision
 * occurs. This hit box does not interact with the z component of objects, and thus makes a
 *
 * @author Sugaku
 */
public class SquareHitBox implements HitBox { // todo equals method.

    /**
     * The current position of the game object.
     */
    protected Vector pos = Vector.ZERO;

    /**
     * The width of the HitBox.
     */
    protected final double width;

    /**
     * The height of the HitBox.
     */
    protected final double height;

    /**
     * Creates a new square hit box with the given position and relative sizes.
     *
     * @param width  The width of the hit box.
     * @param height The height of the hit box.
     * @param pos    The center position of this hit box.
     */
    public SquareHitBox (double width, double height, Vector pos) {
        this(width, height);
        this.pos = pos;
    }

    /**
     * Creates a new square hit box with the given relative sizes in the horizontal and vertical directions. This hit
     * box will be centered at (0, 0, 0) until pos is updated with {@link #setPos(Vector)}.
     *
     * @param width  The width of the hit box.
     * @param height The height of the hit box.
     */
    public SquareHitBox (double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Accessor method for the height of this HitBox.
     *
     * @return The height value of this HitBox.
     */
    public double getHeight () {
        return height;
    }

    /**
     * Accessor method for the width of this HitBox.
     *
     * @return The width value of this HitBox.
     */
    public double getWidth () {
        return width;
    }

    /**
     * Tests whether the given point is within this HitBox or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is inside this HitBox.
     */
    @Override
    public boolean isInside (Vector test) {
        if (test.getX() > pos.getX() - (width / 2.0) && test.getX() < pos.getX() + (width / 2.0))
            return test.getY() > pos.getY() - (height / 2.0) && test.getY() < pos.getY() + (height / 2.0);
        return false;
    }

    /**
     * Tests whether the given point is touching this HitBox or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is on the boundary of this HitBox.
     */
    @Override
    public boolean touching (Vector test) {
        if (test.getX() == pos.getX() - (width / 2.0) || test.getX() == pos.getX() + (width / 2.0))
            return test.getY() >= pos.getY() - (height / 2.0) && test.getY() <= pos.getY() + (height / 2.0);
        else if (test.getY() == pos.getY() - (height / 2.0) || test.getY() == pos.getY() + (height / 2.0))
            return test.getX() >= pos.getX() - (width / 2.0) && test.getX() <= pos.getX() + (width / 2.0);
        return false;
    }

    /**
     * Returns a collection of test points to determine if this HitBox is colliding with another.
     *
     * @return A list of test points to look for collisions at.
     */
    @Override
    public Collection<Vector> getTestPoints () {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        return  vectors;
    }

    /**
     * Accessor method for the position of the HitBox.
     *
     * @return Returns the current position of this HitBox.
     */
    @Override
    public Vector getPos () {
        return pos;
    }

    /**
     * Sets the center position of this hit box. Used to center hit boxes on game objects.
     *
     * @param pos The new center position of this hit box.
     */
    @Override
    public void setPos (Vector pos) {
        this.pos = pos;
    }

    /**
     * Draws this hit box to the given graphics panel. Different hit boxes may appear differently when drawn.
     *
     * @param panel The panel to draw the hit box test points to.
     */
    @Override
    public void drawHitBox (GraphicsPanelInterface panel) {
        int y = (int) (pos.getY() + (height / 2.0));
        int x = (int) (pos.getX() - (width / 2.0));
        for (int i = x; i <= (int) (pos.getX() + (width / 2.0)); i++) panel.setPixel(i, y, Color.BLUE.brighter());
        for (int i = (int) (pos.getY() - (height / 2.0)); i <= y; i++) panel.setPixel(x, i, Color.BLUE.brighter());
        y = (int) (pos.getY() - (height / 2.0));
        x = (int) (pos.getX() + (width / 2.0));
        for (int i = (int) (pos.getX() - (width / 2.0)); i <= x; i++) panel.setPixel(i, y, Color.BLUE.brighter());
        for (int i = y; i <= (int) (pos.getY() + (height / 2.0)); i++) panel.setPixel(x, i, Color.BLUE.brighter());
    }
}
