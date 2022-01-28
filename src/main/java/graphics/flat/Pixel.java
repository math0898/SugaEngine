package graphics.flat;

import java.awt.*;

/**
 * Represents a single pixel in 2d space with its own color and position.
 *
 * @param x The x position of this pixel.
 * @param y The y position of this pixel.
 * @param color The color of the pixel.
 * @author Sugaku
 */
public record Pixel (int x, int y, Color color) { }
