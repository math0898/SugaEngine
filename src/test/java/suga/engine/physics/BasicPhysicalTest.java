package suga.engine.physics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the BasicPhysical object. The object is very simple and should simply store position, velocity,
 * and acceleration. These should also be updated appropriately each tick (call to update).
 *
 * @author Sugaku
 */
class BasicPhysicalTest {

    /**
     * An instance of BasicPhysical we can use to test.
     */
    private static final BasicPhysical physical = new BasicPhysical(Vector.ZERO, Vector.ZERO, Vector.ZERO, 0.0);

    /**
     * Tests whether physical updates it's velocity and acceleration appropriately.
     * todo: parameterize?
     */
    @Test
    void update () {
        physical.setAcceleration(new Vector(1.5, 3.0, 0));
        physical.setVelocity(new Vector(-1.5, 6.0, 1));
        physical.setPos(new Vector(0, 0, 0));
        assertEquals(Vector.ZERO, physical.getPos(), "Object has not yet started moving and should have the position initialized");
        physical.update();
        assertEquals(new Vector(-1.5, 6.0, 1), physical.getPos(), "Velocity should get added to the position.");
        assertEquals(new Vector(0, 9.0, 1), physical.getVelocity(), "Acceleration should be added to velocity.");
        physical.update();
        assertEquals(new Vector(-1.5, 15.0, 2), physical.getPos(), "Velocity should get added to the position.");
        assertEquals(new Vector(1.5, 12.0, 1), physical.getVelocity(), "Acceleration should be added to velocity.");
    }
}
