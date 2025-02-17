package views.terminal;

import views.terminal.command.Command;

import java.util.Map;

/**
 * This class is responsible for running the command line interface.
 * It is where the game loop is located.
 * @author uepiy
 */

public class CommandHandler {
    private static final String QUIT_COMMAND = "quit";
    private static final String LOAD_COMMAND = "load";
    private static final String COMPETITION_COMMAND = "competition";
    private static final String SHOW_COMMAND = "show";
    private static final String SHOW_MONSTERS_COMMAND = "show monsters";
    private static final String SHOW_ACTIONS_COMMAND = "show actions";
    private static final String SHOW_STATS_COMMAND = "show stats";
    private static final String ACTION_COMMAND = "action";
    private static final String PASS_COMMAND = "pass";
    private boolean running;
    private Map<String, Command> commands;

    CommandHandler() {
        initCommands();
    }

    public void start() {
        running = true;
        runHandler();
    }

    public void quit() {
        running = false;
    }

    private void initCommands() {
        commands = Map.of(
                QUIT_COMMAND, new QuitCommand(this),
                LOAD_COMMAND, new LoadCommand(),
                COMPETITION_COMMAND, new CompetitionCommand(),
                SHOW_COMMAND, new ShowCommand(),
                SHOW_MONSTERS_COMMAND, new ShowMonstersCommand(),
                SHOW_ACTIONS_COMMAND, new ShowActionsCommand(),
                ACTION_COMMAND, new ActionCommand(),
                PASS_COMMAND, new PassCommand()
        );
    }
    private void runHandler() {
        while (running) {
            System.out.print("Enter command: ");
            String input = System.console().readLine();
            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            String[] args = new String[inputParts.length - 1];
            System.arraycopy(inputParts, 1, args, 0, args.length);
            if (commands.containsKey(command)) {
                System.out.println(commands.get(command).execute(args));
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
