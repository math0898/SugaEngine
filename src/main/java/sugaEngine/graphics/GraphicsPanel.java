package sugaEngine.graphics;

import sugaEngine.graphics.flat.DrawListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A graphics panel is used to draw graphics to the computer screen. It can either be 3d or 2d.
 *
 * @author Sugaku
 */
public abstract class GraphicsPanel extends JPanel {

    /**
     * A map of drawing listeners with their priority.
     */
    protected Map<DrawListener.Priorities, ArrayList<DrawListener>> drawingListeners = new HashMap<>();

    /**
     * Calls every program that would like add pixels to the panel before it's displayed.
     *
     * @param width The width of the pixels that can be defined.
     * @param height The height of the pixels that can be defined.
     */
    public abstract void drawing (int width, int height);

    /**
     * Adds the drawing listener to this Graphics2d instance.
     *
     * @param listener The listener to register.
     */
    public void registerListener (DrawListener listener) {
        registerListener(DrawListener.Priorities.FOREGROUND, listener);
    }

    /**
     * Adds the drawing listener to this Graphics2d instance with the given priority.
     *
     * @param priority The priority to register the listener at.
     * @param listener The listener to register.
     */
    public void registerListener (DrawListener.Priorities priority, DrawListener listener) {
        if (!drawingListeners.containsKey(priority)) drawingListeners.put(priority, new ArrayList<>());
        drawingListeners.get(priority).add(listener);
    }

    /**
     * De-registers all draw listeners for this panel. New ones need to be added with
     * {@link #registerListener(DrawListener)}.
     */
    public void clearListeners () {
        drawingListeners = new HashMap<>();
    }
}
