package suga.engine.graphics;

import suga.engine.threads.SugaThread;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Implementations of GraphicsPanel likely need to extend JPanel so that they can be used to draw.
 *
 * @author Sugaku
 */
public interface GraphicsPanelInterface {

    /**
     * Calls every program that would like add pixels to the panel before it's displayed.
     *
     * @param width The width of the pixels that can be defined.
     * @param height The height of the pixels that can be defined.
     */
    void drawing (int width, int height);

    /**
     * Sets the thread that is calling repaint on this GraphicsPanel.
     *
     * @param thread The thread that will be calling repaint() on this object.
     */
    void setThread (SugaThread thread);

    /**
     * Adds the drawing listener to this instance.
     *
     * @param listener The listener to register.
     */
    void registerListener (DrawListener listener);

    /**
     * Adds the drawing listener to this instance with the given priority.
     *
     * @param priority The priority to register the listener at.
     * @param listener The listener to register.
     */
    void registerListener (DrawListener.Priorities priority, DrawListener listener);

    /**
     * De-registers all draw listeners for this panel. New ones need to be added with
     * {@link #registerListener(DrawListener)}.
     */
    void clearListeners ();

    /**
     * Used to set the values of pixels.
     *
     * @param x The x to set.
     * @param y The y to set.
     * @param c The color to set the pixel to.
     */
    void setPixel (int x, int y, Color c);

    /**
     * Used to create a rectangle of pixels assigned to a particular color.
     *
     * @param x The top left most corner of the rectangle.
     * @param y The top left most corner of the rectangle.
     * @param width How wide the rectangle is.
     * @param height How tall the rectangle is.
     * @param c The color to set the rectangle to.
     */
    void setRectangle (int x, int y, int width, int height, Color c);

    /**
     * Used to set a block of pixels with the given radius.
     *
     * @param x The x position to center this 'big pixel'.
     * @param y The y position to center this 'big pixel'.
     * @param r The radius of this 'big pixel'.
     * @param c The color to set these pixels to.
     */
    void setBigPixel (int x, int y, int r, Color c);

    /**
     * Adds the given image to the list of images to draw this frame. Attempts to load an image from resources.
     *
     * @param x The x position of this image.
     * @param y The y position of this image.
     * @param width The width of this image.
     * @param height The height of this image.
     * @param path The path of the image to draw on screen.
     */
    void addImage (int x, int y, int width, int height, String path);

    /**
     * Adds the given image to the list of images to draw this frame.
     *
     * @param x The x position of this image.
     * @param y The y position of this image.
     * @param width The width of this image.
     * @param height The height of this image.
     * @param image The image to draw to the screen.
     */
    void addImage (int x, int y, int width, int height, BufferedImage image);

    /**
     * Called each frame by the GraphicsThread. This method should be inherited from JComponent but is defined in
     * Component.
     */
    void repaint ();
}
