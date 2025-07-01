package exam.kit.exceptions;

/**
 * Represents an exception that is thrown when a configuration file is malformed.
 * The format is given in the assignment.
 * @author uepiy
 */

public class MalformedConfigException extends Exception {
    private static final String EXCEPTION_MESSAGE_PREFIX = "Error: ";
    /**
     * Creates a new MalformedConfigException with the specified message.
     * It is prefixed with: "Error: ".
     * @param message the message to display
     */
    public MalformedConfigException(String message) {
        super(EXCEPTION_MESSAGE_PREFIX + message);
    }
}
