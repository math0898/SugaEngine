package sugaEngine;

import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.threads.SugaThread;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Games require a main game loop to run along with game components that need to be run every game cycle.
 *
 * @author Sugaku
 */
// todo rename to Game, v2.*.*
public interface GameInterface { // todo carry over most methods from BasicGame.

    /**
     * Sets the graphics panel being used by this game.
     *
     * @param panel The panel to assign to this game.
     */
    void setPanel (GraphicsPanel panel);

    /**
     * Sets the key listener currently being used by this game.
     *
     * @param listener The new key listener that this game should use.
     */
    void setKeyListener (KeyListener listener);

    /**
     * Sets the mouse listener currently being used by this game.
     *
     * @param listener The new mouse listener that this game should use.
     */
    void setMouseListener (MouseListener listener);

    /**
     * Processes inputs given by players. Is run during pause.
     */
    void processInput ();

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    void loop ();

    /**
     * Sets the thread that is calling loop() on this Game.
     *
     * @param thread The thread that will be calling loop() on this object.
     */
    void setThread (SugaThread thread);
}
