package animus.objects;

import sugaEngine.GameObject;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

/**
 * The main character for this ProjectAnimus.
 *
 * @author Sugaku
 */
public class PlayerCharacter extends GameObject {

    /**
     * Jump status of the player. 0 - Jump available, 1 - Jump used, acceleration applied, 2 - Jump used, acceleration removed.
     */
    private int jump = 0;

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     */
    public PlayerCharacter () {
        super(false, 20, 60);
        accel = new Vector(0, 0.05, 0);
        pos = new Vector(100, 10, 0);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Override
    public void runLogic () {
        pos.add(velocity);
        if (accel.getX() == 0) {
            if (velocity.getX() > 0) velocity.setX(velocity.getX() - 0.1);
            else if (velocity.getX() < 0) velocity.setX(velocity.getX() + 0.1);
        }
        velocity.add(accel);
        if (jump > 0) jump++;
        if (jump == 5) accel.add(new Vector(0, 1, 0));
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, Graphics2d panel) {
        panel.setRectangle((int) pos.getX() - (int) (this.width / 2), (int) pos.getY() - (int) (this.height / 2), (int) this.width, (int) this.height, Color.decode("#288654"));
    }

    /**
     * Runs collision logic. Should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (HitBox obj) {
        if (velocity.getY() > 0) velocity.setY(0);
    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (HitBox obj) {
        if (velocity.getY() > 0) velocity.setY(0);
        if (jump >= 15) jump = 0;
    }

    /**
     * Makes the player jump.
     */
    public void jump () {
        if (jump == 0) {
            jump = 1;
            accel.add(new Vector(0, -1, 0));
        }
    }
}