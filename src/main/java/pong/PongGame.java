package pong;

import pong.ai.PaddleAgent;
import pong.objects.Ball;
import pong.objects.Goal;
import pong.objects.Paddle;
import pong.objects.Wall;
import pong.ui.DividingLine;
import pong.ui.PauseMenu;
import pong.ui.ScoreCounter;
import sugaEngine.AIAgent;
import sugaEngine.Game;
import sugaEngine.GameObject;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.Vector;
import sugaEngine.threads.GameLogicThread;
import sugaEngine.threads.GraphicsThread;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
     * Whether the game pong is currently in dev mode or not.
     */
    private static boolean devMode = false;

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public PongGame (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        super(panel, listener, mouseListener);
        addDrawingListener(new PauseMenu());
        addDrawingListener(new DividingLine());
        addDrawingListener(new ScoreCounter(playerScore, new Vector((panel.getWidth() * 3.0) / 8.0, panel.getHeight() / 32.0, 0)));
        addDrawingListener(new ScoreCounter(aiScore, new Vector((panel.getWidth() * 5.0) / 8.0, panel.getHeight() / 32.0, 0)));
        Paddle aiPaddle = new Paddle(new Vector(panel.getWidth() / 8.0, panel.getHeight() / 2.0, 0));
        Ball ball = new Ball(new Vector((panel.getWidth() * 3.0) / 4.0, panel.getHeight() / 2.0, 0), new Vector(-6.0, 0, 0));
        addGameObject("Ball", ball);
        addGameObject("AI Paddle", aiPaddle);
        addAgent(new PaddleAgent(aiPaddle, ball));
        addGameObject("Player Paddle", new Paddle(new Vector((panel.getWidth() * 7.0) / 8.0, panel.getHeight() / 2.0, 0)));
        addGameObject("Wall1", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0, -50, 0)));
        addGameObject("Wall2", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0,  panel.getHeight() + 49, 0)));
        addGameObject("Player Goal",
                new Goal(new Vector(((panel.getWidth() * 7.0) / 8.0) + 150, panel.getHeight() / 2.0, 0), panel.getHeight(), this));
        addGameObject("AI Goal", new Goal(new Vector((panel.getWidth() / 8.0) - 150, panel.getHeight() / 2.0, 0), panel.getHeight(), this));
    }

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    @Override
    public void loop () {
        physics.checkCollisions();
        for (AIAgent a : agents) a.logic();
        for (GameObject gO : objects.values()) gO.runLogic();
    }

    /**
     * Adds to the given player's score.
     *
     * @param target The player that gets 1 added to their score.
     */
    public void addScore (String target) {
        if (target.equals("AI")) aiScore.incrementAndGet();
        else if (target.equals("Player")) playerScore.incrementAndGet();
    }

    /**
     * Serves the pong ball towards the given player.
     *
     * @param target The player that is 'serving' the ball.
     */
    public void serve (String target) {
        double posY = new Random().nextDouble() * (panel.getHeight() / 4.0);
        double velY = new Random().nextBoolean() ? 6.0 : -6.0;
        if (velY < 0) posY += panel.getHeight() / 2.0;
        GameObject ball = objects.get("Ball");
        if (ball == null) return;
        ball.getPos().setY(posY);
        ball.getPos().setX(panel.getWidth() / 2.0);
        ball.getVelocity().setY(velY);
        ball.getVelocity().setX(target.equals("AI") ? -6.0 : 6.0);
    }

    /**
     * Returns whether this PongGame is in dev mode or not.
     *
     * @return True if Pong is in dev mode. Otherwise, false.
     */
    public static boolean getDevMode () {
        return devMode;
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
                case (int) 'A' -> { // todo remove.
                    playerScore.incrementAndGet();
                    aiScore.incrementAndGet();
                }
                case 73 -> devMode = !devMode; // I
                case 38 -> objects.get("Player Paddle").getAccel().add(new Vector(0, -1 * Paddle.PADDLE_ACCELERATION, 0)); // UP ARROW
                case 40 -> objects.get("Player Paddle").getAccel().add(new Vector(0, Paddle.PADDLE_ACCELERATION, 0)); // DOWN ARROW
            }
        }
        keys = keyListener.getKeysDepressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            pressedKeys.remove((Integer) key);
            switch (key) {
                case 38 -> objects.get("Player Paddle").getAccel().add(new Vector(0, Paddle.PADDLE_ACCELERATION, 0)); // UP ARROW
                case 40 -> objects.get("Player Paddle").getAccel().add(new Vector(0, -1 * Paddle.PADDLE_ACCELERATION, 0)); // DOWN ARROW
            }
        }
    }
}
