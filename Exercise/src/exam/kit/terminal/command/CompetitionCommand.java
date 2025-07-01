package exam.kit.terminal.command;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.game.Game;
/**
 * Represents a command that starts a competition.
 * @author uepiy
 */
public class CompetitionCommand implements Command {
    private final Game game;
    /**
     * Creates a new CompetitionCommand with the specified game.
     * @param game system to act on
     */
    public CompetitionCommand(Game game) {
        this.game = game;
    }
    @Override
    public CommandResult execute(String[] args) {
        try {
            return new CommandResult(CommandResultType.SUCCESS, game.startCombat(args));
        } catch (InvalidArgumentException e) {
            return new CommandResult(CommandResultType.FAILURE, e.getMessage());
        }
    }
}
