package views.terminal.command;

import controller.transform.ConfigFileExtraction;
import controller.transform.ConfigParser;
import model.interaction.ModelInterface;

import java.util.List;

public class LoadCommand implements Command {
    private final ModelInterface model;
    public LoadCommand(ModelInterface model) {
        this.model = model;
    }
    @Override
    public CommandResult execute(String[] args) {
        try {
            ConfigFileExtraction.checkFileValidity(args[0]);
            model.replaceModel(ConfigParser.parseConfig(ConfigFileExtraction.extractActionLines(args[0]), ConfigFileExtraction.parseMonsterLines(args[0])));
        } catch (Exception e) {
            return new CommandResult(ResultType.FAILURE, "Failed to load game.");
        }
        return null;
    }
}
