package views.terminal.command;

import model.interaction.ModelInterface;

public class ActionCommand implements Command {
    private final ModelInterface model;
    public ActionCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
