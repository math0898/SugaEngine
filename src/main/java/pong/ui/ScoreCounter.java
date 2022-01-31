package pong.ui;

import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.physics.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> digits = new ArrayList<>();
        int score = this.score.get();
        digits.add(score % 10);
        score = (int) (score / 10.0);
        while (score > 0) {
            digits.add(score % 10);
            score = (int) (score / 10.0);
        }
        Vector origin = pos.clone();
        for (Integer i : digits) {
            drawDigit(panel, origin, i);
            origin.add(new Vector(-40, 0, 0));
        }
    }

    /**
     * Draws the given digit to the screen, centered on the given position.
     *
     * @param panel The panel to draw the number to.
     * @param origin The origin point to draw the number relative to.
     * @param digit The digit to draw to the screen.
     */
    public void drawDigit (Graphics2d panel, Vector origin, int digit) {
        switch (digit) {
            case 0 -> {
                for (int x = -10; x <= 10; x += 10)
                    for (int y = 10; y <= 50; y += 10) {
                        if ((y > 10 && y < 50) && x == 0) continue;
                        panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + y), 10, Color.WHITE);
                    }
            }
            case 1 -> {
                for (int y = 10; y <= 50; y += 10) panel.setBigPixel((int) origin.getX(), (int) (origin.getY() + y), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 50), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 20), 10, Color.WHITE);
            }
            case 2 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + 20), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 40), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 50), 10, Color.WHITE);
            }
            case 3 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + 20), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + 40), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 50), 10, Color.WHITE);
            }
            case 4 -> {
                for (int y = 10; y <= 50; y += 10) panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + y), 10, Color.WHITE);
                for (int y = 10; y <= 30; y += 10) panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + y), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
            }
            case 5 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 20), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + 40), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 50), 10, Color.WHITE);
            }
            case 6 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 20), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + 40), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 40), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 50), 10, Color.WHITE);
            }
            case 7 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                for (int y = 10; y <= 50; y += 10) panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + y), 10, Color.WHITE);
            }
            case 8 -> {
                for (int x = -10; x <= 10; x += 10)
                    for (int y = 10; y <= 50; y += 10) {
                        if ((y == 20 || y == 40) && x == 0) continue;
                        panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + y), 10, Color.WHITE);
                    }
            }
            case 9 -> {
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 10), 10, Color.WHITE);
                for (int x = -10; x <= 10; x += 10) panel.setBigPixel((int) (origin.getX() + x), (int) (origin.getY() + 30), 10, Color.WHITE);
                panel.setBigPixel((int) (origin.getX() - 10), (int) (origin.getY() + 20), 10, Color.WHITE);
                for (int y = 10; y <= 50; y += 10) panel.setBigPixel((int) (origin.getX() + 10), (int) (origin.getY() + y), 10, Color.WHITE);
            }
        }
    }
}
