package pong.objects;

import pong.PongGame;
import sugaEngine.GameObject;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

/**
 * A paddle is controlled by a player or AI and is used to hit the ball back and forth.
 *
 * @author Sugaku
 */
public class Paddle extends GameObject {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos The starting position of the Paddle.
     */
    public Paddle (Vector pos) {
        super(false, 11, 51);
        this.pos = pos;
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
        Color c = PongGame.getPaused() ? Color.GRAY : Color.WHITE;
        for (int i = (int) Math.max(0, pos.getY() - 46); i <= pos.getY() + 46; i++)
            panel.setBigPixel((int) pos.getX(), i, 10, c);
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (HitBox obj) {

    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (HitBox obj) {

    }
}
