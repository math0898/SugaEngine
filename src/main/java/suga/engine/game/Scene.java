package suga.engine.game;

import suga.engine.input.keyboard.KeyValue;

import java.awt.*;

/**
 * The Scene object is a collection of objects, AIAgents, and a physics engine. Each game likely has multiple scenes.
 *
 * @author Sugaku
 */
public interface Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    boolean load (Game game);

    /**
     * Passes a keyboard input into the scene.
     *
     * @param key     The value of the key pressed.
     * @param pressed True if the key was pressed, false if it was released.
     */
    void keyboardInput (KeyValue key, boolean pressed);

    /**
     * Passes a mouse input into the scene.
     *
     * @param pos     The position of the mouse when it was clicked.
     * @param pressed True if the button was pressed, false if it was released.
     */
    void mouseInput (Point pos, boolean pressed);
}
