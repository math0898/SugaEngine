package suga.engine.physics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import suga.engine.physics.collidables.Collidable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
     * TODO: implement
     */
    @Test
    void checkCollisions () {
    }

    /**
     * PhysicsEngine's should ask each registered Physical, and Object to update their velocity, acceleration, and position.
     */
    @Test
    void update () {
        Physical phy = Mockito.mock(Physical.class);
        Collidable collidable = Mockito.mock(Collidable.class);
        Collidable obj = Mockito.mock(Collidable.class);
        engine.addPhysical(phy);
        engine.addCollidable(collidable);
        engine.addObject(obj);
        engine.update();
        verify(phy, times(1)).update();
        verify(collidable, times(0)).update();
        verify(obj, times(1)).update();
    }
}
