package sugaEngine.graphics;

import sugaEngine.input.KeyValues;

import java.util.List;

/**
 * The BasicMenu class implements the Menu interface. It may have any number of options to choose from. The options are
 * always stacked vertically.
 *
 * @author Sugaku
 */
public abstract class BasicMenu implements Menu {

    /**
     * The list of options for this menu.
     */
    protected List<String> options;

    /**
     * The currently selected option.
     */
    protected int currentSelection = 0;

    /**
     * Creates a new BasicMenu with the given options for buttons.
     *
     * @param options The menu options for this menu.
     */
    public BasicMenu (List<String> options) {
        if (options.size() == 0) throw new IllegalArgumentException("Menus must have at least one option!");
        this.options = options;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {

    }

    /**
     * Selects the currently hovered menu option and takes any actions that should be taken.
     */
    public abstract void select ();

    /**
     * Moves to another menu option based on the given key input.
     *
     * @param key The key that was pressed.
     */
    @Override
    public void move (KeyValues key) {
        switch (key) {
            case ARROW_UP -> currentSelection = (currentSelection - 1 + options.size()) % options.size();
            case ARROW_DOWN -> currentSelection = (currentSelection + 1 + options.size()) % options.size();
        }
    }

    /**
     * Checks the position of the mouse to determine which option to highlight.
     */
    @Override
    public void checkMouse () {

    }
}
