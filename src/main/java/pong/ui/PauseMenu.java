package pong.ui;

import pong.PongGame;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.Vector;

import java.awt.*;

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
            drawLetter('c', panel, Color.WHITE, new Vector(width / 2, height / 2, 0));
            drawLetter('o', panel, Color.WHITE, new Vector((width / 2) + 36, height / 2, 0));
            drawLetter('n', panel, Color.WHITE, new Vector((width / 2) + 72, height / 2, 0));
        }
    }

    /**
     * Attempts to draw the given char to the screen at the given seed point.
     *
     * @param c The char to print to the screen.
     * @param panel The panel to draw the letter to.
     * @param color The color to draw to the screen.
     * @param center The seed point for the letter.
     */
    public void drawLetter (char c, Graphics2d panel, Color color, Vector center) {
        switch (c) {
            case 'c', 'C' -> drawLetterC(panel, color, center);
            case 'o', 'O' -> drawLetterO(panel, color, center);
            case 'n', 'N' -> drawLetterN(panel, color, center);
        }
    }

    /**
     * Draws the letter 'c' to the panel centered on the given position.
     *
     * @param panel The panel to draw the letter 'c' to.
     * @param color The color to draw the letter 'c' in.
     * @param center The seed point for the letter 'c'.
     */
    private void drawLetterC (Graphics2d panel, Color color, Vector center) {
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 12, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 6, (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 6, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY() - 18, 6, color);
    }

    /**
     * Draws the letter 'o' to the panel centered on the given position.
     *
     * @param panel The panel to draw the letter 'o' to.
     * @param color The color to draw the letter 'o' in.
     * @param center The seed point for the letter 'o'.
     */
    private void drawLetterO (Graphics2d panel, Color color, Vector center) {
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 12, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 6, (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 6, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY() - 12, 6, color);
    }

    /**
     * Draws the letter 'n' to the panel centered on the given position.
     *
     * @param panel The panel to draw the letter 'n' to.
     * @param color The color to draw the letter 'n' in.
     * @param center The seed point for the letter 'n'.
     */
    private void drawLetterN (Graphics2d panel, Color color, Vector center) {
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY() - 12, 6, color);
        panel.setBigPixel((int) center.getX() + 6, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 12, (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 12, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY() - 6, 6, color);
        panel.setBigPixel((int) center.getX() + 24, (int) center.getY() - 24, 6, color);
        panel.setBigPixel((int) center.getX() + 24, (int) center.getY() - 18, 6, color);
        panel.setBigPixel((int) center.getX() + 24, (int) center.getY() - 12, 6, color);
        panel.setBigPixel((int) center.getX(), (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 18, (int) center.getY(), 6, color);
        panel.setBigPixel((int) center.getX() + 24, (int) center.getY() - 6, 6, color);
    }
}
