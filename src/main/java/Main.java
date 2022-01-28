import graphics.flat.Graphics2d;

import javax.swing.*;
import java.awt.*;

/**
 * Main execution class for testing the Graphics Library.
 *
 * @author Sugaku
 */
public class Main {

    /**
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        Graphics2d panel = new Graphics2d();
        panel.setBackground(Color.GREEN.darker().darker());
        JFrame frame = new JFrame("Java Frame Title");
        frame.setSize(1920, 1080);
        for (int i = 0; i < 400; i++) panel.setPixel(i, i, Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
