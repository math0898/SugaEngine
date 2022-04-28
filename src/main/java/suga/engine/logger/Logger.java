package suga.engine.logger;

/**
 * Loggers receive messages from the running program at various levels. After which they're printed to an output device
 * of some sort.
 *
 * @author Sugaku
 */
public interface Logger { // todo how about a 'print level'?

    /**
     * Sends a general message to the logger.
     *
     * @param message The message to send to the logger.
     */
    void log (String message);

    /**
     * Sends a message to the logger at a specific level.
     *
     * @param message The message to send to the logger.
     * @param level   The level at which to send the message.
     */
    void log (String message, Level level);

    /**
     * Sends a message to the logger with, or without, the level prefix at the given level.
     *
     * @param message The message to send to the logger.
     * @param level   The level at which to send the message.
     * @param prefix  Whether to send the level prefix with this message or not.
     */
    void log (String message, Level level, boolean prefix);
}
