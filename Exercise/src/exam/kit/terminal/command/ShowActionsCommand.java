package exam.kit.terminal.command;

import exam.kit.exceptions.InvalidCommandExecutionException;
import exam.kit.game.Game;

/**
 * A command that shows the available actions for the current monster in combat.
 * @author uepiy
 */

public class ShowActionsCommand implements Command {
    private final Game game;
    /**
     * Creates a new show actions command.
     * @param game the game system to interact with
     */
    public ShowActionsCommand(Game game) {
        this.game = game;
    }

    @Override
    public CommandResult execute(String[] args) {
        try {
            return new CommandResult(CommandResultType.SUCCESS, game.showActions());
        } catch (InvalidCommandExecutionException e) {
            return new CommandResult(CommandResultType.FAILURE, e.getMessage());
        }
    }
}
