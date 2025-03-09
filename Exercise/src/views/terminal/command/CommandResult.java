package views.terminal.command;

public class CommandResult {
    private final String message;
    private final ResultType resultType;

    public CommandResult( ResultType resultType, String message) {
        this.message = message;
        this.resultType = resultType;
    }

    public String getMessage() {
        return message;
    }

    public ResultType getResultType() {
        return resultType;
    }
}
