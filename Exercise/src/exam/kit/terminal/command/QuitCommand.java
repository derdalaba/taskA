package exam.kit.terminal.command;


import exam.kit.terminal.interaction.CommandHandler;

/**
 * Represents a command to quit the program.
 * @author uepiy
 */

public class QuitCommand implements Command {
    private final CommandHandler handler;
    /**
     * Creates a new QuitCommand with the specified handler.
     * @param handler the handler to quit
     */
    public QuitCommand(CommandHandler handler) {
        this.handler = handler;
    }
    @Override
    public CommandResult execute(String [] args) {
        handler.quit();
        return new CommandResult(CommandResultType.SUCCESS, NO_MESSAGE);
    }
}
