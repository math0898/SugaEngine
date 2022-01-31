package pong.ui;

import pong.PongGame;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;

import java.awt.*;

/**
 * The DividingLine class's job is simply to draw the dividing line seen in the center of pong games.
 *
 * @author Sugaku
 */
public class DividingLine implements DrawListener {

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
        for (int y = 10; y < height; y += 20)
            panel.setBigPixel(width / 2, y, 5, c);
    }
}
