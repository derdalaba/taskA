package exam.kit.exceptions;

/**
 * Represents an exception that is thrown when a command is entered but cannot be executed
 * because of invalid system state.
 * @author uepiy
 */

public class InvalidCommandExecutionException extends Exception {
    private static final String EXCEPTION_MESSAGE_PREFIX = "Error: ";
    /**
     * Creates a new InvalidCommandExecutionException with the specified message.
     * It is prefixed with: "Error: ".
     * @param message the message to display
     */
    public InvalidCommandExecutionException(String message) {
        super(EXCEPTION_MESSAGE_PREFIX + message);
    }
}
