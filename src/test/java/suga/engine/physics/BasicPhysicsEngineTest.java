package suga.engine.physics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.collidables.ElasticCollider;
import suga.engine.physics.hitboxes.SquareHitBox;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

/**
 * Tests for the BasicPhysicsEngine to ensure it correctly implements PhysicsEngine.
 *
 * @author Sugaku
 */
class BasicPhysicsEngineTest {

    /**
     * An instance of BasicPhysicsEngine to test.
     */
    private static BasicPhysicsEngine engine = new BasicPhysicsEngine();

    /**
     * Resets objects so each test can get a blank slate.
     */
    @BeforeEach
    void reset () {
        engine = new BasicPhysicsEngine();
    }

    /**
     * The PhysicsEngine should poll each object and check if they collide with any other objects registered in the
     * engine.
     * TODO: Check accuracy instead of just errors.
     */
    @Test
    void checkCollisions () {
        Collidable col1 = new ElasticCollider(Vector.ZERO, Vector.ZERO, Vector.ZERO, 1.0, new SquareHitBox(0, 0));
        Collidable col2 = new ElasticCollider(Vector.ZERO, Vector.ZERO, Vector.ZERO, 1.0, new SquareHitBox(10, 10));
        engine.addCollidable(col1);
        engine.addCollidable(col2);
        assertDoesNotThrow(engine::checkCollisions);
    }

    /**
     * PhysicsEngine's should ask each registered Physical, and Object to update their velocity, acceleration, and position.
     */
    @Test
    void update () {
        Physical phy = mock(Physical.class);
        Collidable collidable = mock(Collidable.class);
        Collidable obj = mock(Collidable.class);
        engine.addPhysical(phy);
        engine.addCollidable(collidable);
        engine.addObject(obj);
        engine.update();
        verify(phy, times(1)).update();
        verify(collidable, times(0)).update();
        verify(obj, times(1)).update();
    }
}
