package animus.objects;

import sugaEngine.GameObject;
import sugaEngine.Vector;
import sugaEngine.graphics.flat.Graphics2d;

import java.awt.*;

public class FloatyCube extends GameObject {

    /**
     * Creates a new FloatyCube game object.
     */
    public FloatyCube () {
        pos = new Vector(0, 0, 0);
        velocity = new Vector(-1, -1, 0);
        accel = new Vector(0,0,0);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Override
    public void runLogic () {
        if (pos.getX() + 10 >= 1920) velocity.setX(-1);
        else if (pos.getX() - 10 <= 0) velocity.setX(1);
        if (pos.getY() + 10 >= 1080) velocity.setY(-1);
        else if (pos.getY() - 10 <= 0) velocity.setY(1);
        pos.add(velocity);
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
