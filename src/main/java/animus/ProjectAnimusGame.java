package animus;

import animus.objects.BoxyBox;
import animus.objects.FloatyCube;
import sugaEngine.Game;
import sugaEngine.GameKeyListener;
import sugaEngine.MusicPlayer;
import sugaEngine.physics.Vector;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.threads.GameLogicThread;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Main execution point for the animus game including aspects such as the GameLoop.
 *
 * @author Sugaku
 */
public class ProjectAnimusGame extends Game {

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
     */
    public ProjectAnimusGame (GraphicsPanel panel, GameKeyListener listener) {
        super(panel, listener);
        new MusicPlayer("/media/music/Itro & Tobu - Cloud 9.wav");
        panel.registerListener(new GameUI());
        addGameObject("Floaty Cube", new FloatyCube());
        addGameObject("Boxy Box", new BoxyBox(new Vector(100, 100, 0), 50, 50, Color.GREEN.darker().darker().darker()));
        addGameObject("Boxy Box2", new BoxyBox(new Vector(500, 700, 0), 500, 20, Color.RED.darker().darker()));
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
            if (pressedKeys.contains(key)) continue;
            else pressedKeys.add(key);
            switch (key) {
                case 27 -> GameLogicThread.setPaused(!GameLogicThread.getPaused()); // ESC
                case 40 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, 0.1, 0)); // UP ARROW
                case 39 -> objects.get("Floaty Cube").getAccel().add(new Vector(0.1, 0, 0)); // RIGHT ARROW
                case 37 -> objects.get("Floaty Cube").getAccel().add(new Vector(-0.1, 0, 0)); // LEFT ARROW
                case 38 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, -0.1, 0)); // DOWN ARROW
            }
        }
        keys = keyListener.getKeysDepressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            pressedKeys.remove((Integer) key); // Remove Object not Index
            switch (key) {
                case 40 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, -0.1, 0)); // UP ARROW
                case 39 -> objects.get("Floaty Cube").getAccel().add(new Vector(-0.1, 0, 0)); // RIGHT ARROW
                case 37 -> objects.get("Floaty Cube").getAccel().add(new Vector(0.1, 0, 0)); // LEFT ARROW
                case 38 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, 0.1, 0)); // DOWN ARROW
            }
        }
    }
}
