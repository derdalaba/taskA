package views.terminal.command;

import model.interaction.ModelInterface;
import views.terminal.CommandHandler;

public class QuitCommand implements Command {
    private final CommandHandler handler;
    public QuitCommand(CommandHandler handler) {
        this.handler = handler;
    }
    @Override
    public CommandResult execute(String[] args) {
        handler.quit();
        return new CommandResult(ResultType.SUCCESS, "Quitting game.");
    }
}
