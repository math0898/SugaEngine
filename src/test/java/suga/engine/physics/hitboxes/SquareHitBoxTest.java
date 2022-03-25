package suga.engine.physics.hitboxes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import suga.engine.physics.Vector;

import static org.junit.jupiter.api.Assertions.*;

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
        hitBox = new SquareHitBox(20, 20); // 10 in each direction from 0.
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
    @Test
    void touching () {
        assertFalse(hitBox.touching(Vector.ZERO), "The origin should be the center of the test hit box, and thus inside.");
        for (int x : new int[]{ -5, -5, 5, 5 })
            for (int y : new int[]{ -5, 5, -5, 5 })
                assertFalse(hitBox.touching(new Vector(x, y, 0)), "Should be inside of hit box (" + x + ", " + y + ").");
        for (int w : new int[]{ -10, 10 }) {
            assertTrue(hitBox.touching(new Vector(w, 3, 0)), "Should be on boundary of hit box (" + w + ", " + 3 + ").");
            assertTrue(hitBox.touching(new Vector(3, w, 0)), "Should be on boundary of hit box (" + 3 + ", " + w + ").");
        }
        for (int x : new int[]{ -15, -15, 15, 15 })
            for (int y : new int[]{ -15, 15, -15, 15 })
                assertFalse(hitBox.isInside(new Vector(x, y, 0)), "Should be outside of hit box (" + x + ", " + y + ").");
    }

    @Test
    void getTestPoints () {
        fail("unimplemented");
    }

    @Test
    void getPos () {
        fail("unimplemented");
    }

    @Test
    void setPos () {
        fail("unimplemented");
    }

    @Test
    void drawHitBox () {
        fail("unimplemented");
    }
}