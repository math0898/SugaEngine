package sugaEngine.graphics;

/**
 * A DrawListener is registered with a Graphics system and called on every frame to check if something needs to be drawn.
 *
 * @author Sugaku
 */
public interface DrawListener {

    /**
     * The priorities that a drawing listener can be called at.
     */
    enum Priorities {

        /**
         * Called last for GUI elements.
         */
        GUI,

        /**
         * Called for foreground elements.
         */
        FOREGROUND,

        /**
         * Called for fundamental background elements.
         */
        BACKGROUND
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel The panel to apply changes to.
     */
    void applyChanges (int width, int height, GraphicsPanel panel);
}
