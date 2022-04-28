package suga.engine.logger;

/**
 * The general logger prints all messages it receives to the console with ANSI color codes, a file located at
 * ./logs/latest.log, and another file located at ./logs/<date>.log.
 *
 * @author Sugaku
 */
public class GeneralLogger implements Logger {

    /**
     * The level to start printing messages at.
     */
    private Level printLevel = Level.DEBUG;

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
                \u001B[0;36m             |___/                   |___/            \s""", Level.INFO, false);
        log("Using general logger. This can be changed using GameEngine.setLogger(logger).");
        // todo initialize files
    }

    /**
     * Sets the level at which messages should be output. Messages at the given level will also be printed.
     *
     * @param level The level which to start printing messages at.
     */
    @Override
    public void setLevel (Level level) {
        printLevel = level;
    }

    /**
     * Sends the given exception to the logger.
     *
     * @param exception The exception to print to the console.
     */
    @Override
    public void log (Exception exception) {
        log(exception, Level.EXCEPTION);
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
     * Sends the given exception to the logger at a different level.
     *
     * @param exception The exception to print to the console.
     * @param level     The level at which to send the exception to the console.
     */
    @Override
    public void log (Exception exception, Level level) {
        log(exception.getMessage(), level);
        int i = 0;
        for (StackTraceElement se : exception.getStackTrace()) {
            if (i >= 10) break;
            i++;
            log("        " + se.toString(), level, false);
        }
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
        if (level.getUrgency() < printLevel.getUrgency()) return;
        String output = "";
        if (prefix) output += level.toString();
        else output += level.getColorCode();
        output += message;
        // todo files IO
        System.out.println(output);
    }
}
