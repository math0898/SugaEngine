import graphics.flat.DrawListener;
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
     * A general drawing listener used for the sake of testing.
     *
     * @author Sugaku
     */
    static class GeneralListener implements DrawListener {

        /**
         * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
         *
         * @param width  The width of the pixel map.
         * @param height The height of the pixel map.
         * @param panel The panel to apply changes to.
         */
        @Override
        public void applyChanges(int width, int height, Graphics2d panel) {
            for (int i = 0; i < Math.min(width, height); i++) panel.setPixel(i, i, Color.CYAN);
            System.out.println("Draw got called!");
        }
    }

    /**
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        Graphics2d panel = new Graphics2d();
        panel.setBackground(Color.GREEN.darker().darker());
        panel.registerListener(new GeneralListener());
        JFrame frame = new JFrame("Java Frame Title");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
