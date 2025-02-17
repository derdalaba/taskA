package views.terminal.command;

/**
 * This interface defines the basic structure of a command and its necessary methods.
 * @author uepiy
 */
public interface Command {
    /**
     * This method executes the command on the combat model.
     * @param args The arguments passed to the command.
     * @return The message to be displayed to the user base on the model's response.
     */
    String execute(String[] args);
}
