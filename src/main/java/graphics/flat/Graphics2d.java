package graphics.flat;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
     * A map of drawing listeners with their priority.
     */
    private static final Map<DrawListener.Priorities, ArrayList<DrawListener>> drawingListeners = new HashMap<>();

    /**
     * A 2d array of colors that each pixel should be in the graphics component.
     */
    private static Color[][] pixels = new Color[1][1];

    /**
     * A helper method to initialize the array of pixels to a size being used in the graphics call.
     *
     * @param width The width of pixels that can be shown on this frame.
     * @param height The height of pixels that can be shown on this frame.
     */
    public void initPixels (int width, int height) {
        pixels = new Color[height][];
        for (int i = 0; i < height; i++) {
            pixels[i] = new Color[width];
            for (int j = 0; j < width; j++) pixels[i][j] = Color.BLACK;
        }
    }

    /**
     * Calls every program that would like add pixels to the panel before it's displayed.
     *
     * @param width The width of the pixels that can be defined.
     * @param height The height of the pixels that can be defined.
     */
    public void drawing (int width, int height) {
        DrawListener.Priorities[] order = new DrawListener.Priorities[]{ DrawListener.Priorities.BACKGROUND, DrawListener.Priorities.FOREGROUND, DrawListener.Priorities.GUI };
        for (int i = 0; i < order.length; i++) {
            ArrayList<DrawListener> listeners = drawingListeners.get(order[i]);
            if (listeners != null) for (DrawListener l : listeners) l.applyChanges(width, height, this);
        }
    }

    /**
     * Called during runtime to repaint the graphics.
     *
     * @param graphics The graphics object to manipulate and use in drawing.
     */
    @Override
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        int width = getWidth();
        int height = getHeight();
        initPixels(width, height);
        drawing(width, height);
        for (int i = 0; i < width; i++) for (int j = 0; j < height; j++) {
            graphics.setColor(pixels[j][i]);
            graphics.fillRect(i, j, 1, 1);
        }
    }

    /**
     * Adds the drawing listener to this Graphics2d instance.
     *
     * @param listener The listener to register.
     */
    public void registerListener (DrawListener listener) {
        registerListener(DrawListener.Priorities.FOREGROUND, listener);
    }

    /**
     * Adds the drawing listener to this Graphics2d instance with the given priority.
     *
     * @param priority The priority to register the listener at.
     * @param listener The listener to register.
     */
    public void registerListener (DrawListener.Priorities priority, DrawListener listener) {
        if (!drawingListeners.containsKey(priority)) drawingListeners.put(priority, new ArrayList<>());
        drawingListeners.get(priority).add(listener);
    }

    /**
     * Used to set the values of pixels.
     *
     * @param x The x to set.
     * @param y The y to set.
     * @param c The color to set the pixel to.
     */
    public void setPixel (int x, int y, Color c) {
        pixels[y][x] = c;
    }
}
