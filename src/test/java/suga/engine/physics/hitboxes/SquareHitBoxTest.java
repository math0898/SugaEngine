package suga.engine.physics.hitboxes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import suga.engine.graphics.GraphicsPanelInterface;
import suga.engine.physics.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the SquareHitBox implementation of HitBox.
 *
 * @author Sugaku
 */
class SquareHitBoxTest {

    /**
     * The instance of SquareHitBox being used for tests.
     */
    private SquareHitBox hitBox;

    /**
     * Resets fields so that they're in their default state after each test.
     */
    @BeforeEach
    void setUp () {
        hitBox = new SquareHitBox(20, 20, Vector.ZERO); // 10 in each direction from 0.
    }

    /**
     * Checks if the given point is inside the hit box or not. Should return false for points on the boundary.
     */
    @Test
    void isInside () {
        assertTrue(hitBox.isInside(Vector.ZERO), "The origin should be the center of the test hit box, and thus inside.");
        for (int x : new int[]{ -5, -5, 5, 5 })
            for (int y : new int[]{ -5, 5, -5, 5 })
                assertTrue(hitBox.isInside(new Vector(x, y, 0)), "Should be inside of hit box (" + x + ", " + y + ").");
        for (int w : new int[]{ -10, 10 }) {
            assertFalse(hitBox.isInside(new Vector(w, 3, 0)), "Should be on boundary of hit box (" + w + ", " + 3 + ").");
            assertFalse(hitBox.isInside(new Vector(3, w, 0)), "Should be on boundary of hit box (" + 3 + ", " + w + ").");
        }
        for (int x : new int[]{ -15, -15, 15, 15 })
            for (int y : new int[]{ -15, 15, -15, 15 })
                assertFalse(hitBox.isInside(new Vector(x, y, 0)), "Should be outside of hit box (" + x + ", " + y + ").");
    }

    /**
     * Checks if the given point is along the boundary of the hit box or not. Should return false for interior points.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/suga/engine/physics/hitboxes/SquareHitBox/touching.csv", numLinesToSkip = 2, delimiter = ',')
    void touching (int width, int height, int cx, int cy, int cz, int x, int y, int z, boolean expected, String reason) {
        HitBox hitBox = new SquareHitBox(width, height, new Vector(cx, cy, cz));
        Vector testPoint = new Vector(x, y, z);
        assertEquals(hitBox.isTouching(testPoint), expected, reason + " HitBox:" + hitBox + " TestPoint:" + testPoint);
    }

    /**
     * A square should have four test points, one at each corner.
     */
    @Test
    void getTestPoints () {
        Collection<Vector> points = hitBox.getTestPoints();
        Collection<Vector> expected = new ArrayList<>(Arrays.asList(new Vector(10, 10, 0), new Vector(10, -10, 0),
                                                                  new Vector(-10, 10, 0), new Vector(-10, -10, 0)));
        for (Vector v : expected)
            assertTrue(points.contains(v), "Expected to find: " + v.toString());
        for (Vector v : points)
            assertTrue(expected.contains(v), "Found unexpected point: " + v.toString());
    }

    /**
     * Should return the current center position of the hit box.
     */
    @Test
    void getPos () {
        assertEquals(Vector.ZERO, hitBox.getPos(), "Hit box was created to be centered at (0, 0, 0).");
    }

    /**
     * Setting the position should make getPos() return the new position.
     */
    @Test
    void setPos () {
        Random rand = new Random();
        Vector v = new Vector(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        hitBox.setPos(v);
        assertEquals(v, hitBox.getPos(), "Hit box was created to be centered at (0, 0, 0).");
    }

    /**
     * This test has the very low bar of drawing a single pixel to the given graphics panel.
     */
    @Test
    void drawHitBox () {
        GraphicsPanelInterface panel = mock(GraphicsPanelInterface.class);
        hitBox.drawHitBox(panel);
        verify(panel, atLeastOnce()).setRectangle(Mockito.any(int.class), Mockito.any(int.class), Mockito.any(int.class), Mockito.any(int.class), Mockito.any(Color.class));
    }

    /**
     * A square HitBox has a constant height upon creation which should at no time change.
     */
    @Test
    void getHeight () {
        assertEquals(20, hitBox.getHeight(), "Testing HitBox was made with height 20, getHeight should return that.");
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int h = rand.nextInt();
            SquareHitBox shb = new SquareHitBox(10, h);
            assertEquals(h, shb.getHeight(), "Square HitBox should return the height it was created at.");
        }
    }

    /**
     * A square HitBox has a constant width upon creation which should at no time change.
     */
    @Test
    void getWidth () {
        assertEquals(20, hitBox.getHeight(), "Testing HitBox was made with width 20, getWidth should return that.");
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int w = rand.nextInt();
            SquareHitBox shb = new SquareHitBox(w, 10);
            assertEquals(w, shb.getWidth(), "Square HitBox should return the width it was created at.");
        }
    }
}
