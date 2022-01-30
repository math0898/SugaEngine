package pong.ui;

import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.Vector;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The ScoreCounter draws the current score value to the screen.
 *
 * @author Sugaku
 */
@SuppressWarnings("ClassCanBeRecord")
public class ScoreCounter implements DrawListener {

    /**
     * The counter for the ScoreCounter.
     */
    private final AtomicInteger score;

    /**
     * The position to display this ScoreCounter.
     */
    private final Vector pos;

    /**
     * Creates a new ScoreCounter object with the given score, and centered at the given position.
     *
     * @param score The score that should be displayed by this score counter.
     * @param pos The center position that this score counter should be displayed at.
     */
    public ScoreCounter (AtomicInteger score, Vector pos) {
        this.score = score;
        this.pos = pos;
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
        switch (score.get()) {
            case 0 -> {
                for (int x = -11; x <= 10; x += 10)
                    for (int y = 11; y <= 51; y += 10) {
                        if ((y > 11 && y < 50) && x == -1) continue;
                        panel.setBigPixel((int) (pos.getX() + x), (int) (pos.getY() + y), 10, Color.WHITE);
                }
            }
            case 1 -> {
                for (int y = 11; y <= 51; y += 10) panel.setBigPixel((int) (pos.getX() - 1), (int) (pos.getY() + y), 10, Color.WHITE);
                for (int x = -11; x <= 10; x += 10) panel.setBigPixel((int) (pos.getX() + x), (int) (pos.getY() + 51), 10, Color.WHITE);
                panel.setBigPixel((int) (pos.getX() - 11), (int) (pos.getY() + 21), 10, Color.WHITE);
            }
        }
    }
}
