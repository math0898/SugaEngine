package pong.objects;

import pong.PongGame;
import sugaEngine.GameObject;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

public class Ball extends GameObject {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos The starting position of the ball.
     * @param vel The starting velocity of the ball.
     */
    public Ball (Vector pos, Vector vel) {
        super(false, 21, 21);
        this.pos = pos;
        this.velocity = vel;
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
        panel.setBigPixel((int) pos.getX(), (int) pos.getY(), 10, Color.WHITE);
        if (PongGame.getDevMode()) drawTestPoints(panel);
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

    /**
     * Returns the name of this object for use during collisions.
     *
     * @return The name of this object.
     */
    @Override
    public String getName () {
        return "Ball";
    }
}
