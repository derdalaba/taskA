package exam.kit.exceptions;

/**
 * Exception for invalid terminal input.
 * This exception will be thrown if the input is invalid not illogical.
 * @author uepiy
 */

public class InvalidArgumentException extends Exception {
    private static final String EXCEPTION_MESSAGE_PREFIX = "Error: ";

    /**
     * Constructor for the exception.
     * @param message the message to be displayed with error prefix.
     */
    public InvalidArgumentException(String message) {
        super(EXCEPTION_MESSAGE_PREFIX + message);
    }
}
