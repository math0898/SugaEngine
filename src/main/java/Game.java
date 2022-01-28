
/**
 * Games require a main game loop to run which is encapsulated within this interface.
 *
 * @author Sugaku
 */
public interface Game {

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    void loop ();
}
