package sugaEngine;

/**
 * A vector can represent a velocity, acceleration, or position in 3d space.
 *
 * @author Sugaku
 */
public class Vector {

    /**
     * The x value of this vector.
     */
    private double x;

    /**
     * The y value of this vector.
     */
    private double y;

    /**
     * The z value of this vector.
     */
    private double z;

    /**
     * Creates a new vector with the given values of x, y, and z.
     *
     * @param x The x value of the vector.
     * @param y The y value of the vector.
     * @param z The z value of the vector.
     */
    public Vector (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Accessor method for the x value of this vector.
     *
     * @return The x value of this vector.
     */
    public double getX () {
        return x;
    }

    /**
     * Accessor method for the y value of this vector.
     *
     * @return The y value of this vector.
     */
    public double getY () {
        return y;
    }

    /**
     * Accessor method for the z value of this vector.
     *
     * @return The z value of this vector.
     */
    public double getZ () {
        return z;
    }

    /**
     * Sets the x value of the vector.
     *
     * @param x The new x value of the vector.
     */
    public void setX (double x) {
        this.x = x;
    }

    /**
     * Sets the y value of the vector.
     *
     * @param y The new y value of the vector.
     */
    public void setY (double y) {
        this.y = y;
    }

    /**
     * Sets the z value of the vector.
     *
     * @param z The new z value of teh vector.
     */
    public void setZ (double z) {
        this.z = z;
    }

    /**
     * Adds the given vector to this vector.
     *
     * @param vec The vector to add into this one.
     */
    public void add (Vector vec) {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
    }
}
