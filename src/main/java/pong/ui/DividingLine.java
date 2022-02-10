package pong.ui;

import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanel;

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
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        Color c = /* PongGame.getPaused() */ true ? Color.DARK_GRAY : Color.WHITE; // todo reimplement.
        for (int y = 10; y < height; y += 20)
            panel.setBigPixel(width / 2, y, 5, c);
    }
}
