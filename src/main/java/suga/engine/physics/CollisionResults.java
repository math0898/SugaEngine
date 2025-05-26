package suga.engine.physics;

/**
 * The record CollisionResults holds the results of a collision TODO: so that it can be passed to objects.
 *
 * @param touching  Two objects are touching if one or more test points are on the other's surface.
 * @param colliding Objects collide when their test points enter another object.
 * @author Sugaku
 */
public record CollisionResults (boolean touching, boolean colliding) {

    /**
     * Creates a merged version of the two given CollisionResults. Positive results with override negative results.
     *
     * @param r1 The first result to bring into the merger.
     * @param r2 The second result to merge.
     * @return The newly created and merged CollisionResults.
     */
    public static CollisionResults merge (CollisionResults r1, CollisionResults r2) {
        return new CollisionResults(r1.touching() || r2.touching(), r1.colliding() || r2.colliding());
    }
}
