package suga.engine.physics;

/**
 * The record CollisionResults holds the results of a collision TODO: so that it can be passed to objects.
 *
 * @param touching  Two objects are touching if one or more test points are on the other's surface.
 * @param colliding Objects collide when their test points enter another object.
 * @author Sugaku
 */
public record CollisionResults (boolean touching, boolean colliding) {
}
