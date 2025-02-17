package views.terminal.exceptions;

/**
 * This exception is thrown when the command argument is invalid.
 * This exception can be thrown when the argument is not in the correct format or is not valid.
 * The model is somewhat able to also throw this exception when the argument is not valid.
 * @author uepiy
 */

public class InvalidArgumentException extends Exception {
    /**
     * This constructor creates an InvalidArgumentException.
     * @param message The message describes the reason of the exception throw and will be directly displayed.
     */
    public InvalidArgumentException(String message) {
        super(message);
    }
}
