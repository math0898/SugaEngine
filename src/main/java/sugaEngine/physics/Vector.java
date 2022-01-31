package sugaEngine.physics;

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

    /**
     * Scales each coordinate by the given scalar.
     *
     * @param cX The scalar for the x coordinate.
     * @param cY The scalar for the y coordinate.
     * @param cZ The scalar for the z coordinate.
     */
    public void scale (double cX, double cY, double cZ) {
        x *= cX;
        y *= cY;
        z *= cZ;
    }

    /**
     * Scales this vector by the given scalar.
     *
     * @param c The value to scale the vector by.
     */
    public void scale (double c) {
        scale(c, c, c);
    }

    /**
     * Converts this vector into a string.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString () {
        return "<" + x + ", " + y + ", " + z + ">";
    }

    /**
     * Returns a new copy of the vector with the same data contained.
     *
     * @return A copy of this vector with the same values.
     */
    @SuppressWarnings("MethodDoesntCallSuperMethod") // clone () not supported.
    @Override
    public Vector clone () {
        return new Vector(this.x, this.y, this.z);
    }

    /**
     * Returns the magnitude of the vector.
     *
     * @return The magnitude of the vector.
     */
    public double magnitude () {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }
}
