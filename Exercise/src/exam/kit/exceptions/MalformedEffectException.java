package exam.kit.exceptions;

/**
 * Represents an exception that is thrown when an effect is malformed.
 * @author uepiy
 */

public class MalformedEffectException extends Exception {
    private static final String ERROR_PREFIX = "Error: ";
    /**
     * Creates a new malformed effect exception.
     * @param message the message of the exception prefixed with "Error: "
     */
    public MalformedEffectException(String message) {
        super(ERROR_PREFIX + message);
    }
}
