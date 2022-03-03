package main;

import animus.ProjectAnimusGame;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.graphics.Graphics2d;
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
        JFrame frame = new JFrame("SugaEngine - PONG");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        new GraphicsThread(panel, 60).start();
        try {
            new GameLogicThread(new ProjectAnimusGame(panel, new GameKeyListener(frame), new GameMouseListener(frame)), 60).start();
        } catch (Exception e) {
            System.out.println(e.toString());
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
        }
    }
}
