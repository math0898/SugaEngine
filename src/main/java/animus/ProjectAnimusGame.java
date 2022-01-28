package animus;

import animus.objects.FloatyCube;
import sugaEngine.Game;
import sugaEngine.GameKeyListener;
import sugaEngine.KeyValues;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.threads.GameLogicThread;

import java.util.Stack;

/**
 * Main execution point for the animus game including aspects such as the GameLoop.
 *
 * @author Sugaku
 */
public class ProjectAnimusGame extends Game {

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     */
    public ProjectAnimusGame (GraphicsPanel panel, GameKeyListener listener) {
        super(panel, listener);
        addGameObject("Floaty Cube", new FloatyCube());
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
        Stack<Integer> keys = keyListener.getKeysPressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            System.out.println(key);
            switch (key) {
                case 27 -> GameLogicThread.setPaused(!GameLogicThread.getPaused()); // ESC
            }
        }
    }
}
