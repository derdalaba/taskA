package exam.kit.terminal.command;

/**
 * Interface for a command.
 * Describes necessary functionality for all commands.
 * @author uepiy
 */

public interface Command {
    /**
     * Standard message for a command not returning a message.
     */
    String NO_MESSAGE = "";

    /**
     * Execute the command.
     * @param args the arguments passed to the command.
     * @return the result of the interaction.
     */
    CommandResult execute(String[] args);
}
