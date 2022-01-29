import animus.ProjectAnimusGame;
import sugaEngine.GameKeyListener;
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
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        Graphics2d panel = new Graphics2d();
        panel.setBackground(Color.BLACK);
        JFrame frame = new JFrame("Project Animus");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        GameKeyListener listener = new GameKeyListener();
        frame.addKeyListener(listener);
        new GraphicsThread(panel).start();
        new GameLogicThread(new ProjectAnimusGame(panel, listener), 60).start();
    }
}
