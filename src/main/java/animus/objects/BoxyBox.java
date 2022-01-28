package animus.objects;

import sugaEngine.GameObject;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.Collidable;
import sugaEngine.physics.Vector;

import java.awt.*;

public class BoxyBox extends GameObject {

    /**
     * The color of this cube.
     */
    private final Color color;

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos       The position of the object.
     * @param width     The width of the HitBox.
     * @param height    The height of the HitBox.
     * @param color     The color of the box.
     */
    public BoxyBox (Vector pos, double width, double height, Color color) {
        super(false, width, height);
        this.pos = pos;
        this.color = color;
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
        for (int i = Math.max(0, (int) (pos.getX() - (this.width / 2))); i < Math.min(width, pos.getX() + (this.width / 2.0) ); i++)
            for (int j = Math.max(0, (int) (pos.getY() - (this.height / 2))); j < Math.min(height, pos.getY() + (this.height / 2.0)); j++)
                panel.setPixel(i, j, color);
    }

    /**
     * Runs collision logic. Should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (Collidable obj) {
        // Immutable
    }
}
