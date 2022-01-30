package pong;

import sugaEngine.Game;
import sugaEngine.GameKeyListener;
import sugaEngine.GameMouseListener;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.threads.GameLogicThread;
import sugaEngine.threads.GraphicsThread;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Main game class for the Pong game.
 *
 * @author Sugaku
 */
public class PongGame extends Game {

    /**
     * These are keys that are currently being held. That can be useful information in it of itself but this is used to
     * ignore future key pressed messages.
     */
    List<Integer> pressedKeys = new ArrayList<>();

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public PongGame (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        super(panel, listener, mouseListener);
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
        Stack<MouseEvent> mice = mouseListener.getEvents();
        while (mice.size() > 0) mice.pop();
        Stack<Integer> keys = keyListener.getKeysPressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            if (pressedKeys.contains(key)) continue;
            pressedKeys.add(key);
            switch (key) {
                case 27 -> GameLogicThread.setPaused(!GameLogicThread.getPaused()); // ESC
                case 76 -> System.out.println("Average fps: " + GraphicsThread.getFPS()); // L
            }
        }
        keys = keyListener.getKeysDepressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            pressedKeys.remove((Integer) key);
        }
    }
}
