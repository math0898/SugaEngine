package pong.ui;

import pong.PongGame;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.input.GameMouseListener;

/**
 * The PauseMenu is used by players to restart the game, exit pong, return to main menu, or to resume the game. Should
 * support mouse clicks and buttons should change on hover.
 *
 * @author Sugaku
 */
public class PauseMenu implements DrawListener {

    /**
     * The mouse listener being used to highlight active elements of the PauseMenu and get when the player clicks on an
     * element.
     */
    private GameMouseListener mouseListener;

    /**
     * Creates a new PauseMenu instance with the given GameMouseListener.
     *
     * @param mouseListener The mouse listener that will be associated with this PauseMenu.
     */
    public PauseMenu (GameMouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, Graphics2d panel) {
        if (PongGame.getPaused()) {
            panel.addImage((width / 2) - (38 * 3), (height / 2) - 258, 38 * 6, 5 * 6, "/pong/Continue.png");
            panel.addImage((width / 2) - (29 * 3), (height / 2) - 138, 29 * 6, 5 * 6, "/pong/Restart.png");
            panel.addImage((width / 2) - (34 * 3), (height / 2) - 18, 34 * 6, 5 * 6,"/pong/Settings.png");
            panel.addImage((width / 2) - (43 * 3), (height / 2) + 102, 43 * 6, 5 * 6,"/pong/MainMenu.png");
            panel.addImage((width / 2) - (17 * 3), (height / 2) + 222, 17 * 6, 5 * 6,"/pong/Quit.png");
        }
    }
}
