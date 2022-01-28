package graphics.flat;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * A 2d graphics window that can be manipulated with the given methods.
 *
 * @author Sugaku
 */
public class Graphics2d extends JPanel {

    /**
     * The serial version of the panel.
     */
    @Serial
    private static final long serialVersionUID = 9879187320923L;

    /**
     * A 2d array of colors that each pixel should be in the graphics component.
     */
    private static final Color[][] pixels = new Color[1][1];

    /**
     * A helper method to initialize the array of pixels to a size being used in the graphics call.
     *
     * @param width The width of pixels that can be shown on this frame.
     * @param height The height of pixels that can be shown on this frame.
     */
    public void initPixels (int width, int height) {

    }

    /**
     * Called during runtime to repaint the graphics.
     *
     * @param graphics The graphics object to manipulate and use in drawing.
     */
    @Override
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        initPixels(getWidth(), getHeight());
        for (int i = 0; i < 400; i ++) for (int j = 0; j < 400; j++) {
            graphics.setColor(pixels[i][j]);
            graphics.fillRect(i, j, 1, 1);
        }
    }

    /**
     * Used to set the values of pixels.
     *
     * @param i The row to set.
     * @param j The column to set.
     * @param c The color to set the pixel to.
     */
    public void setPixel (int i, int j, Color c) {
        pixels[i][j] = c;
    }
}
