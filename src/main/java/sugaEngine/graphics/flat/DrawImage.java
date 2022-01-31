package sugaEngine.graphics.flat;

import java.awt.image.BufferedImage;

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
