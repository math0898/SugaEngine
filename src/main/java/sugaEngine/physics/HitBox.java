package sugaEngine.physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Every collidable object needs a HitBox. This is a box where if a test point overlaps with a box then a collision
 * occurs.
 *
 * @author Sugaku
 */
public abstract class HitBox {

    /**
     * The current position of the game object.
     */
    protected Vector pos;

    /**
     * The width of the HitBox.
     */
    private final double width;

    /**
     * The height of the HitBox.
     */
    private final double height;

    /**
     * Creates a new HitBox with the given relative sizes in the horizontal and vertical directions.
     *
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public HitBox (double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Tests whether the given point is within this HitBox or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is inside this HitBox.
     */
    public boolean isInside (Vector test) {
        if (test.getX() >= pos.getX() - (width / 2.0) && test.getX() <= pos.getX() + (width / 2.0))
            return test.getY() >= pos.getY() - (height / 2.0) && test.getY() <= pos.getY() + (height / 2.0);
        return false;
    }

    /**
     * Returns a collection of test points to determine if this HitBox is colliding with another.
     *
     * @return A list of test points to look for collisions at.
     */
    public Collection<Vector> getTestPoints () {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        return  vectors;
    }
}
