package views.terminal.command;

import model.interaction.ModelInterface;

public class ShowActionsCommand implements Command {
    private final ModelInterface model;
    public ShowActionsCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
