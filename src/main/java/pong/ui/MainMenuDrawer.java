package pong.ui;

import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * The MainMenuDrawer handles the drawing of the main menu elements such as title, start, settings, and quit buttons.
 *
 * @author Sugaku
 */
public class MainMenuDrawer implements DrawListener {

    /**
     * The title image as a BufferedImage so it can remain in RAM.
     */
    private final BufferedImage title;

    /**
     * Creates a new MainMenuDrawer by loading the needed images from jar resources.
     */
    public MainMenuDrawer () throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/pong/Title.png");
        if (stream != null) title = ImageIO.read(stream);
        else throw new IOException("Failed to access /pong/Title.png resource!");
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        panel.addImage(100, 100, 500, 50, title);
    }
}
