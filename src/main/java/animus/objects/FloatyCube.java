package animus.objects;

import sugaEngine.GameObject;
import sugaEngine.physics.Vector;
import sugaEngine.graphics.flat.Graphics2d;

import java.awt.*;

public class FloatyCube extends GameObject {

    /**
     * Creates a new FloatyCube game object.
     */
    public FloatyCube () {
        super(false, 20, 20);
        pos = new Vector(11, 11, 0);
        velocity = new Vector(-1, -1, 0);
        accel = new Vector(0,0,0);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Override
    public void runLogic () {
        if (pos.getX() + 10 >= 1920 || pos.getX() - 10 <= 0) velocity.scale(-1, 1, 1);
        if (pos.getY() + 10 >= 1080 || pos.getY() - 10 <= 0) velocity.scale(1, -1, 1);
        super.runLogic();
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
        for (int i = Math.max(0, (int) pos.getX() - 10); i < Math.min(width, pos.getX() + 10); i++)
            for (int j = Math.max(0, (int) pos.getY() - 10); j < Math.min(height, pos.getY() + 10); j++)
                panel.setPixel(i, j, Color.CYAN);
    }
}
