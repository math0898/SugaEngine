package pong.scenes;

import pong.ui.MainMenuDrawer;
import sugaEngine.Game;
import sugaEngine.Scene;

import java.io.IOException;

/**
 * The main menu for the PongGame.
 *
 * @author Sugaku
 */
public class MainMenu extends Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        try {
            game.addDrawingListener(new MainMenuDrawer());
        } catch (IOException exception) {
            return false;
        }
        return true;
    }
}
