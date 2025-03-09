package views.terminal.command;

import model.interaction.ModelInterface;

public class ShowStatsCommand implements Command {
    private final ModelInterface model;
    public ShowStatsCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        return null;
    }
}
