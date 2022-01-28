import graphics.flat.DrawListener;
import graphics.flat.Graphics2d;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
         * The number of frames that have completed since the last print.
         */
        int frames = 0;

        /**
         * The last time that the number of frames was printed.
         */
        long lastPrint = 0;

        /**
         * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
         *
         * @param width  The width of the pixel map.
         * @param height The height of the pixel map.
         * @param panel The panel to apply changes to.
         */
        @Override
        public void applyChanges (int width, int height, Graphics2d panel) {
            if (System.currentTimeMillis() - 1000 >= lastPrint) {
                System.out.println("Last second had " + frames + " frames:");
                frames = 0;
                lastPrint = System.currentTimeMillis();
            }
            frames++;
            Random rand = new Random();
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            for (int i = Math.max(0, x - 10); i < Math.min(width, x + 10); i++)
                for (int j = Math.max(0, y - 10); j < Math.min(height, y + 10); j++)
                    panel.setPixel(i, j, Color.CYAN);
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
        new GraphicsThread(panel).start();
    }
}
