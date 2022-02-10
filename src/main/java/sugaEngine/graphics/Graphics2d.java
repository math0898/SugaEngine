package sugaEngine.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A 2d graphics window that can be manipulated with the given methods.
 *
 * @author Sugaku
 */
public class Graphics2d extends GraphicsPanel {

    /**
     * A list of pixels that need to be updated in the next frame.
     */
    private ArrayList<Pixel> updatePoints = new ArrayList<>();

    /**
     * An ArrayList of images that need to be drawn to the screen.
     */
    private List<DrawImage> images = new ArrayList<>();

    /**
     * Represents an image to draw on the screen.
     *
     * @param x The x position of the image.
     * @param y The y position of the image.
     * @param width The width of the image.
     * @param height The height of the image.
     * @param image The actual image to draw.
     * @author Sugaku
     */
    public record DrawImage (int x, int y, int width, int height, BufferedImage image) { }

    /**
     * Represents a single pixel in 2d space with its own color and position.
     *
     * @param x The x position of this pixel.
     * @param y The y position of this pixel.
     * @param color The color of the pixel.
     * @author Sugaku
     */
    public record Pixel (int x, int y, Color color) { }

    /**
     * Called during runtime to repaint the graphics.
     *
     * @param graphics The graphics object to manipulate and use in drawing.
     */
    @Override
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        drawing(getWidth(), getHeight());
        for (Pixel p : updatePoints) {
            graphics.setColor(p.color());
            graphics.fillRect(p.x(), p.y(), 1, 1);
        }
        for (DrawImage i : images) {
            graphics.drawImage(i.image(), i.x(), i.y(), i.width(), i.height(), null);
        }
        updatePoints = new ArrayList<>();
        images = new ArrayList<>();
    }

    /**
     * Used to set the values of pixels.
     *
     * @param x The x to set.
     * @param y The y to set.
     * @param c The color to set the pixel to.
     */
    @Override
    public void setPixel (int x, int y, Color c) {
        updatePoints.add(new Pixel(x, y, c));
    }

    /**
     * Used to create a rectangle of pixels assigned to a particular color.
     *
     * @param x The top left most corner of the rectangle.
     * @param y The top left most corner of the rectangle.
     * @param width How wide the rectangle is.
     * @param height How tall the rectangle is.
     * @param c The color to set the rectangle to.
     */
    @Override
    public void setRectangle (int x, int y, int width, int height, Color c) {
        for (int i = x; i < width + x; i++)
            for (int j = y; j < height + y; j++)
                updatePoints.add(new Pixel(i, j, c));
    }

    /**
     * Used to set a block of pixels with the given radius.
     *
     * @param x The x position to center this 'big pixel'.
     * @param y The y position to center this 'big pixel'.
     * @param r The radius of this 'big pixel'.
     * @param c The color to set these pixels to.
     */
    @Override
    public void setBigPixel (int x, int y, int r, Color c) {
        setRectangle(x - (r / 2), y - (r / 2), r, r, c);
    }

    /**
     * Adds the given image to the list of images to draw this frame. Attempts to load an image from resources.
     *
     * @param x The x position of this image.
     * @param y The y position of this image.
     * @param width The width of this image.
     * @param height The height of this image.
     * @param path The path of the image to draw on screen.
     */
    @Override
    public void addImage (int x, int y, int width, int height, String path) {
        InputStream inputStream = this.getClass().getResourceAsStream(path);
        if (inputStream == null) {
            System.out.println("Attempted to load '" + path + "' and failed.");
            return;
        }
        try {
            BufferedImage image = ImageIO.read(inputStream);
            images.add(new DrawImage(x, y, width, height, image));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Adds the given image to the list of images to draw this frame.
     *
     * @param x The x position of this image.
     * @param y The y position of this image.
     * @param width The width of this image.
     * @param height The height of this image.
     * @param image The image to draw to the screen.
     */
    @Override
    public void addImage (int x, int y, int width, int height, BufferedImage image) {
        images.add(new DrawImage(x, y, width, height, image));
    }
}
