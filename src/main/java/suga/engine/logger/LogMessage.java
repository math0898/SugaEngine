package suga.engine.logger;

/**
 * A LogMessage is a single message that has been sent to a logger.
 *
 * @param level   The level the message was sent at.
 * @param message The message that was sent to the logger.
 *
 * @author Sugaku
 */
public record LogMessage (Level level, String message) { }
