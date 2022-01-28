package animus;

import animus.objects.FloatyCube;
import sugaEngine.Game;
import sugaEngine.graphics.GraphicsPanel;

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
     */
    public ProjectAnimusGame (GraphicsPanel panel) {
        super(panel);
        addGameObject("Floaty Cube", new FloatyCube());
    }
}
