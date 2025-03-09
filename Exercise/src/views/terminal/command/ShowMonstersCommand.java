package views.terminal.command;

import model.interaction.ModelInterface;

public class ShowMonstersCommand implements Command {
    private final ModelInterface model;
    public ShowMonstersCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
