import sugaEngine.Game;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.threads.GameLogicThread;
import sugaEngine.threads.GraphicsThread;

import javax.swing.*;
import java.awt.*;

/**
 * Main execution class for testing the Graphics Library.
 *
 * @author Sugaku
 */
public class Main {

    /**
     * A general Game object created for testing.
     *
     * @author Sugaku
     */
    public static class GeneralGame extends Game {

        /**
         * The delta value for x.
         */
        int dx = 1;

        /**
         * The delta value for y.
         */
        int dy = 1;

        /**
         * The current x position of a box.
         */
        int x = 11;

        /**
         * The current y position of a box.
         */
        int y = 11;

        /**
         * Creates a new game with the given panel used to register GameObjects as draw listeners to.
         *
         * @param panel The panel that GameObjects should register as a listener to.
         */
        public GeneralGame(GraphicsPanel panel) {
            super(panel);
        }

        /**
         * The main logic loop for the game. Will be called depending on the rate of the logic thread.
         */
        @Override
        public void loop () {
            super.loop();

            BoxDrawer.setBox(x, y);
        }

        /**
         * A general drawing listener used for the sake of testing.
         *
         * @author Sugaku
         */
        public static class BoxDrawer implements DrawListener {

            /**
             * The current x position of the box. Set by the game thread.
             */
            static int x;

            /**
             * The current y position of the box. Set by the game thread.
             */
            static int y;

            /**
             * The number of frames that have completed since the last print.
             */
            int frames = 0;

            /**
             * The last time that the number of frames was printed.
             */
            long lastPrint = 0;

            /**
             * Sets the position of the box.
             *
             * @param x The x position of the box.
             * @param y The y position of the box.
             */
            public static void setBox (int x, int y) {
                BoxDrawer.x = x;
                BoxDrawer.y = y;
            }

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
                for (int i = Math.max(0, x - 10); i < Math.min(width, x + 10); i++)
                    for (int j = Math.max(0, y - 10); j < Math.min(height, y + 10); j++)
                        panel.setPixel(i, j, Color.CYAN);
            }
        }
    }

    /**
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        Graphics2d panel = new Graphics2d();
        panel.setBackground(Color.BLACK);
        panel.registerListener(new GeneralGame.BoxDrawer());
        JFrame frame = new JFrame("Java Frame Title");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        new GraphicsThread(panel).start();
        new GameLogicThread(new GeneralGame(panel), 60).start();
    }
}
