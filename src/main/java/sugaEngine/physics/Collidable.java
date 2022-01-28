package sugaEngine.physics;

/**
 * An object that can have collisions with other collidable objects.
 *
 * @author Sugaku
 */
public abstract class Collidable extends HitBox {

    /**
     * Whether this object is allowed to move or if it's velocity is locked at zero.
     */
    protected boolean immutable;

    /**
     * The current velocity of the game object.
     */
    protected Vector velocity = new Vector(0, 0, 0);

    /**
     * The current acceleration of the game object.
     */
    protected Vector accel = new Vector(0,0,0);

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param immutable Whether this object moves during collisions or not.
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public Collidable (boolean immutable, double width, double height) {
        super(width, height);
        this.immutable = immutable;
    }


    /**
     * Runs collision logic. Should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    public abstract void collision (Collidable obj);
}
