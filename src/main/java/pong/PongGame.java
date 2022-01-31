package pong;

import pong.objects.Paddle;
import pong.ui.DividingLine;
import pong.ui.ScoreCounter;
import sugaEngine.Game;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.Vector;
import sugaEngine.threads.GameLogicThread;
import sugaEngine.threads.GraphicsThread;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

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
     * The player score counter.
     */
    private final AtomicInteger playerScore = new AtomicInteger(0);

    /**
     * The AI score counter.
     */
    private final AtomicInteger aiScore = new AtomicInteger(0);

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public PongGame (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        super(panel, listener, mouseListener);
        addDrawingListener(new DividingLine());
        addDrawingListener(new ScoreCounter(playerScore, new Vector((panel.getWidth() * 3.0) / 8.0, panel.getHeight() / 32.0, 0)));
        addDrawingListener(new ScoreCounter(aiScore, new Vector((panel.getWidth() * 5.0) / 8.0, panel.getHeight() / 32.0, 0)));
        addGameObject("Player Paddle", new Paddle(new Vector(panel.getWidth() / 8.0, panel.getHeight() / 2.0, 0)));
        addGameObject("AI Paddle", new Paddle(new Vector((panel.getWidth() * 7.0) / 8.0, panel.getHeight() / 2.0, 0)));
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
                case 27 -> {
                    paused = !paused;
                    GameLogicThread.setPaused(paused); // ESC
                }
                case 76 -> System.out.printf("Average fps: %.1f", GraphicsThread.getFPS()); // L
                case 38 -> { // todo remove.
                    playerScore.incrementAndGet();
                    aiScore.incrementAndGet();
                }
            }
        }
        keys = keyListener.getKeysDepressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            pressedKeys.remove((Integer) key);
        }
    }
}
