package pong.scenes;

import pong.PongGame;
import pong.ai.PaddleAgent;
import pong.objects.Ball;
import pong.objects.Goal;
import pong.objects.Paddle;
import pong.objects.Wall;
import pong.ui.DividingLine;
import pong.ui.PauseMenu;
import pong.ui.ScoreCounter;
import sugaEngine.Game;
import sugaEngine.Scene;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.Vector;

/**
 * The main game is the game with two paddles, a ball, goals, walls etc.
 *
 * @author Sugaku
 */
public class MainGame extends Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        game.clear();
        game.addDrawingListener(new DividingLine());
        Graphics2d panel = (Graphics2d) game.getPanel();
        game.addDrawingListener(new ScoreCounter(((PongGame) game).getPlayerScorer(), new Vector((panel.getWidth() * 3.0) / 8.0, panel.getHeight() / 32.0, 0)));
        game.addDrawingListener(new ScoreCounter(((PongGame) game).getAiScorer(), new Vector((panel.getWidth() * 5.0) / 8.0, panel.getHeight() / 32.0, 0)));
        Paddle aiPaddle = new Paddle(new Vector(panel.getWidth() / 8.0, panel.getHeight() / 2.0, 0));
        Ball ball = new Ball(new Vector((panel.getWidth() * 3.0) / 4.0, panel.getHeight() / 2.0, 0), new Vector(-6.0, 0, 0));
        game.addGameObject("Ball", ball);
        game.addGameObject("AI Paddle", aiPaddle);
        game.addAgent(new PaddleAgent(aiPaddle, ball));
        game.addGameObject("Player Paddle", new Paddle(new Vector((panel.getWidth() * 7.0) / 8.0, panel.getHeight() / 2.0, 0)));
        game.addGameObject("Wall1", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0, -50, 0)));
        game.addGameObject("Wall2", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0,  panel.getHeight() + 49, 0)));
        game.addGameObject("Player Goal",
                new Goal(new Vector(((panel.getWidth() * 7.0) / 8.0) + 150, panel.getHeight() / 2.0, 0), panel.getHeight(), (PongGame) game));
        game.addGameObject("AI Goal",
                new Goal(new Vector((panel.getWidth() / 8.0) - 150, panel.getHeight() / 2.0, 0), panel.getHeight(), (PongGame) game));
        game.addDrawingListener(new PauseMenu(game.getMouseListener()));
        return true;
    }
}
