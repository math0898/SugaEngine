package sugaEngine;

import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;

/**
 * {@link GameInterface} will take this name in version v2.1.1. {@link BasicGame} has the same functionality of Game
 * from versions v1.*.*.
 *
 * @author Sugaku
 */
@Deprecated
public abstract class Game extends BasicGame {

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel         The panel that GameObjects should register as a listener to.
     * @param listener      The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    @Deprecated
    public Game (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        super(panel, listener, mouseListener);
    }
}
