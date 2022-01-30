package pong;

import sugaEngine.Game;
import sugaEngine.GameKeyListener;
import sugaEngine.graphics.GraphicsPanel;

/**
 * Main game class for the Pong game.
 *
 * @author Sugaku
 */
public class PongGame extends Game {

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel    The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     */
    public PongGame (GraphicsPanel panel, GameKeyListener listener) {
        super(panel, listener);
    }

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    @Override
    public void loop () {
        super.loop();
    }

    /**
     * Processes inputs given by players. Is run during pause.
     */
    @Override
    public void processInput () {

    }
}
