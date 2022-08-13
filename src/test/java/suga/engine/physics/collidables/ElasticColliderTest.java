package suga.engine.physics.collidables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import suga.engine.physics.Vector;
import suga.engine.physics.hitboxes.HitBox;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * The unit test for the ElasticCollider implementation of Physical and Collidable.
 *
 * @author Sugaku
 */
class ElasticColliderTest {

    /**
     * An elastic collider used to test each method.
     */
    private ElasticCollider collider;

    /**
     * Creates a new elastic collider before each test.
     */
    @BeforeEach
    void setUp () {
        collider = new ElasticCollider(Vector.ZERO.clone(), new Vector(0, 1, 0), new Vector(0, 1, 0), 1, mock(HitBox.class));
    }

    /**
     * getPosition should return the position being used by the Elastic Collider. Modifying it should also modify the
     * position of the collider.
     */
    @Test
    void getPos () {
        assertEquals(Vector.ZERO, collider.getPos(), "Position should start at (0, 0, 0)");
        Vector v = collider.getPos();
        v.add(new Vector(1, 1, 1));
        assertEquals(new Vector(1, 1, 1), collider.getPos(), "The returned position object shouldn't be a clone, and thus can be modified" +
                "to modify the position of the elastic collider.");
    }

    /**
     * Expected behavior is to override the position vector being used by the object. Modifying the object after setting
     * it to the position of the collider should modify the colliders position.
     */
    @Test
    void setPos () {
        Vector v = new Vector(1, 0, 0);
        collider.setPos(v);
        assertEquals(v, collider.getPos(), "Collider should use given position vector.");
        v.scale(5);
        v.add(new Vector(-123, 9084, 91));
        v.scale(3, -1, 2);
        assertEquals(v, collider.getPos(), "Collider shouldn't create a copy of vector.");
    }

    /**
     * The getVelocity method should return the velocity being used by the Elastic Collider. Modifying it should also
     * modify the velocity of the collider.
     */
    @Test
    void getVelocity () {
        assertEquals(new Vector(0, 1, 0), collider.getVelocity(), "Velocity should start at (0, 1, 0)");
        Vector v = collider.getVelocity();
        v.add(new Vector(1, 1, 1));
        assertEquals(new Vector(1, 2, 1), collider.getVelocity(), "The returned position object shouldn't be a clone, and thus can be modified" +
                "to modify the velocity of the elastic collider.");
    }

    /**
     * Expected behavior is to override the velocity vector being used by the object. Modifying the object after setting
     * it to the velocity of the collider should modify the colliders velocity.
     */
    @Test
    void setVelocity () {
        Vector v = new Vector(1, 0, 0);
        collider.setVelocity(v);
        assertEquals(v, collider.getVelocity(), "Collider should use given velocity vector.");
        v.scale(5);
        v.add(new Vector(-123, 9084, 91));
        v.scale(3, -1, 2);
        assertEquals(v, collider.getVelocity(), "Collider shouldn't create a copy of vector.");
    }

    /**
     * The getAcceleration method should return the acceleration being used by the Elastic Collider. Modifying it should
     * also modify the acceleration of the collider.
     */
    @Test
    void getAcceleration () {
        Vector v = new Vector(0, 1, 0);
        collider.setVelocity(v);
        assertEquals(v, collider.getAcceleration(), "Acceleration should start at (0, 1, 0).");
        v = collider.getAcceleration();
        v.add(new Vector(1, 1, 1));
        assertEquals(new Vector(1, 2, 1), collider.getAcceleration(), "The returned acceleration object shouldn't be a clone, and thus can be modified" +
                "to modify the acceleration of the elastic collider.");
    }

    /**
     * Expected behavior is to override the acceleration object being used by the object. Modifying the object after
     * setting it to the acceleration of the collider should modify the collider's acceleration.
     */
    @Test
    void setAcceleration () {
        Vector v = new Vector(0, 1, 0);
        collider.setAcceleration(v);
        assertEquals(v, collider.getAcceleration(), "Collider should use given velocity vector.");
        v.scale(5);
        v.add(new Vector(-123, 9872, 98));
        v.scale(3, -1, 2);
        assertEquals(v, collider.getAcceleration(), "Collider shouldn't create a copy of vector.");
    }

    @Test
    void getMass () {
        //fail("Un-implemented");
    }

    @Test
    void setMass () {
        //fail("Un-implemented");
    }

    @Test
    void update () {
        //fail("Un-implemented");
    }

    @Test
    void getHitBox () {
        //fail("Un-implemented");
    }

    @Test
    void setHitBox () {
        //fail("Un-implemented");
    }

    @Test
    void collision () {
        //fail("Un-implemented");
    }

    @Test
    void touch () {
        //fail("Un-implemented");
    }
}
