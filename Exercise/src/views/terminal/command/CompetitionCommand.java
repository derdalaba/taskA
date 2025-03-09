package views.terminal.command;

import model.interaction.ModelInterface;

public class CompetitionCommand implements Command {
    private final ModelInterface model;
    public CompetitionCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
