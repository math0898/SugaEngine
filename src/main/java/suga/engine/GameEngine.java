package suga.engine;

import suga.engine.graphics.AbstractGraphicsPanel;
import suga.engine.input.mouse.BasicMouseListener;
import suga.engine.logger.GeneralLogger;
import suga.engine.logger.Logger;
import suga.engine.threads.GameLogicThread;
import suga.engine.threads.GraphicsThread;
import suga.engine.threads.SugaThread;
import suga.engine.input.keyboard.GameKeyListener;
import suga.engine.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * A collection of static methods that are used to make starting, closing and managing a game easier.
 *
 * @author Sugaku
 */
public class GameEngine {

    /**
     * The currently opened frame.
     */
    protected static JFrame frame;

    /**
     * The current graphics thread if one is running.
     */
    protected static SugaThread graphics;

    /**
     * The current game logic thread if one is running.
     */
    protected static SugaThread logic;

    /**
     * The logger currently being used by the GameEngine.
     */
    protected static Logger logger = new GeneralLogger();

    /**
     * An enum of pre-defined resolutions to open a game window at.
     *
     * @author Sugaku
     */
    public enum Window {

        /**
         * Creates the window at the largest possible resolution in full screen mode.
         */
        FULL_SCREEN
    }

    /**
     * Accessor method for the logger being used by the GameEngine.
     *
     * @return The logger currently in use by the GameEngine.
     */
    public static Logger getLogger () {
        return logger;
    }

    /**
     * Setter method for the logger being used by the GameEngine.
     *
     * @param logger The new logger for the GameEngine to use.
     */
    public static void setLogger (Logger logger) {
        GameEngine.logger = logger;
    }

    /**
     * Closes both the logic and graphics thread.
     */
    public static void stop () {
        graphics.setStopped(true);
        logic.setStopped(true);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Creates a new game window with all the possible configuration options being specified.
     *
     * @param width         The width to create the game window at.
     * @param height        The height to create the game window at.
     * @param name          The name for the resulting window.
     * @param border        Whether to hide the border or not when creating the window.
     * @param panel         The graphics panel to be used for this game.
     * @param background    The background color for the panel.
     * @param logicRate     How many times per second the game logic should be called.
     * @param frameRate     How many frames per second should the graphics thread target.
     * @param keyListener   The key listener to be used for this new window. Will override active frame.
     * @param mouseListener The mouse listener to use for this window. Will override active frame.
     * @param game          The game to attach to this window. Will override currently active panel or input listeners.
     */
    public static void launchGameWindow (int width, int height, String name, boolean border, AbstractGraphicsPanel panel,
                                         Color background, int logicRate, int frameRate, GameKeyListener keyListener,
                                         BasicMouseListener mouseListener, Game game) {
        panel.setBackground(background);
        frame = new JFrame(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(!border);
        frame.setVisible(true);
        graphics = new GraphicsThread(panel, frameRate);
        game.setPanel(panel);
        keyListener.setFrame(frame);
        mouseListener.setFrame(frame);
        game.setKeyListener(keyListener);
        game.setMouseListener(mouseListener);
        logic = new GameLogicThread(game, logicRate);
    }
}
