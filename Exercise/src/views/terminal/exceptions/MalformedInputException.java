package views.terminal.exceptions;

/**
 * This exception is thrown when the command line input is malformed.
 * such as when the user inputs an invalid command(undefined or incorrect spelling).
 * @author uepiy
 */
public class MalformedInputException extends Exception {
    /**
     * This constructor creates a MalformedInputException.
     * @param message The message describes the reason of the exception throw and will be directly displayed.
     */
    public MalformedInputException(String message) {
        super(message);
    }
}
