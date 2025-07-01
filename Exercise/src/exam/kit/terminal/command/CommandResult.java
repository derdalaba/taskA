package exam.kit.terminal.command;

/**
 * Represents the result of a terminal.command.
 * @param type Type of result. SUCCESS/FAILURE
 * @param message The message of the result.
 * @author uepiy
 */

public record CommandResult(CommandResultType type, String message) {

}
