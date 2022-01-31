package pong.ui;

import pong.PongGame;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * The PauseMenu is used by players to restart the game, exit pong, return to main menu, or to resume the game. Should
 * support mouse clicks and buttons should change on hover.
 *
 * @author Sugaku
 */
public class PauseMenu implements DrawListener {

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, Graphics2d panel) {
        if (PongGame.getPaused()) {
            for (int x = -144; x <= 144; x += 36)
                for (int y = -240; y <= 240; y += 120)
                    panel.setBigPixel((width / 2) + x, (height / 2) + y, 36, Color.DARK_GRAY);
            try {
                BufferedImage con = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream("/pong/Continue.png")));
                panel.addImage((width / 2) - (38 * 3), (height / 2) - 258, 38 * 6, 5 * 6, con);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
