package views.terminal.command;

import model.interaction.ModelInterface;

/**
 * This interface defines the basic structure of a command and its necessary methods.
 * @author uepiy
 */
public interface Command {
    /**
     * This method executes the command on the combat model.
     * @param args The arguments passed to the command.
     * @return The result to be displayed to the user based on the model's state.
     */
    CommandResult execute(String[] args, ModelInterface model);
}
