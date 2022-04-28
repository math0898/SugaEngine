package suga.engine.logger;

/**
 * The general logger prints all messages it receives to the console with ANSI color codes, a file located at
 * ./logs/latest.log, and another file located at ./logs/<date>.log.
 *
 * @author Sugaku
 */
public class GeneralLogger implements Logger {

    /**
     * Initializes and creates the general logger object.
     */
    public GeneralLogger () {
        log("""
                \u001B[0;36m ____                    _____             _           \s
                \u001B[0;36m/ ___| _   _  __ _  __ _| ____|_ __   __ _(_)_ __   ___\s
                \u001B[0;36m\\___ \\| | | |/ _` |/ _` |  _| | '_ \\ / _` | | '_ \\ / _ \\
                \u001B[0;36m ___) | |_| | (_| | (_| | |___| | | | (_| | | | | |  __/
                \u001B[0;36m|____/ \\__,_|\\__, |\\__,_|_____|_| |_|\\__, |_|_| |_|\\___|
                \u001B[0;36m               |___/                   |___/            \s""", Level.INFO, false);
        log("Using general logger. This can be changed using GameEngine.setLogger(logger).");
        // todo initialize files
    }

    /**
     * Sends a general message to the logger.
     *
     * @param message The message to send to the logger.
     */
    @Override
    public void log (String message) {
        log(message, Level.INFO);
    }

    /**
     * Sends a message to the logger at a specific level.
     *
     * @param message The message to send to the logger.
     * @param level   The level at which to send the message.
     */
    @Override
    public void log (String message, Level level) {
        log(message, level, true);
    }

    /**
     * Sends a message to the logger with, or without, the level prefix at the given level.
     *
     * @param message The message to send to the logger.
     * @param level   The level at which to send the message.
     * @param prefix  Whether to send the level prefix with this message or not.
     */
    @Override
    public void log (String message, Level level, boolean prefix) {
        String output = "";
        if (prefix) output += level.toString();
        else output += level.getColorCode();
        output += message;
        // todo files IO
        System.out.println(output);
    }
}
