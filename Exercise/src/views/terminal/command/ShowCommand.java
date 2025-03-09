package views.terminal.command;

import model.interaction.ModelInterface;

public class ShowCommand implements Command {
    private final ModelInterface model;
    public ShowCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
