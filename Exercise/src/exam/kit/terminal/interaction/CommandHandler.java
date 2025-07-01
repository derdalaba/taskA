package exam.kit.terminal.interaction;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.game.Game;
import exam.kit.terminal.command.Command;
import exam.kit.terminal.command.QuitCommand;
import exam.kit.terminal.command.CompetitionCommand;
import exam.kit.terminal.command.ShowActionsCommand;
import exam.kit.terminal.command.CommandResult;
import exam.kit.terminal.command.CommandResultType;


import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is responsible for handling in and out put.
 * It acts on the game system.
 * @author uepiy
 */

public class CommandHandler {
    private static final String COMMAND_NOT_FOUND_ERROR = "Command not found.";
    private static final String ARGUMENT_SEPARATOR = " ";
    private static final String QUIT_COMMAND = "quit";
    private static final String LOAD_COMMAND = "load";
    private static final String COMPETITION_COMMAND = "competition";
    private static final String SHOW_COMMAND = "show";
    private static final String SHOW_MONSTERS_COMMAND = "show monsters";
    private static final String SHOW_ACTIONS_COMMAND = "show actions";
    private static final String SHOW_STATS_COMMAND = "show stats";
    private static final String ACTION_COMMAND = "action";
    private static final String PASS_COMMAND = "pass";
    private boolean running = false;
    private final Game game;
    private final HashMap<String, Command> commands;

    /**
     * Constructs a new CommandHandler.
     * @param game the game system to interact with
     */
    public CommandHandler(Game game) {
        this.game = game;
        this.commands = initCommands();
        this.running = true;
    }
    private HashMap<String, Command> initCommands() {
        HashMap<String, Command> commands = new HashMap<>();
        commands.put(QUIT_COMMAND, new QuitCommand(this));
        commands.put(COMPETITION_COMMAND, new CompetitionCommand(this.game));
        commands.put(SHOW_ACTIONS_COMMAND, new ShowActionsCommand(this.game));
        return commands;
    }
    private String getCommand(String input) throws InvalidArgumentException {
        List<String> possibleCommands = getPossibleCommands(input);
        if (possibleCommands.isEmpty()) {
            throw new InvalidArgumentException(COMMAND_NOT_FOUND_ERROR);
        }
        return getLongestString(possibleCommands);
    }
    private List<String> getPossibleCommands(String input) {
        List<String> possibleCommands = new ArrayList<>();
        for (String commandName : this.commands.keySet()) {
            if (input.startsWith(commandName)) {
                possibleCommands.add(commandName);
            }
        }
        return possibleCommands;
    }
    private String getLongestString(List<String> strings) {
        String longest = strings.remove(0);
        for (String possibleCommand : strings) {
            if (longest.length() < possibleCommand.length()) {
                longest = possibleCommand;
            }
        }
        return longest;
    }
    private String[] getCommandArgs(String command, String input) {
        String args = input.replaceFirst(command, ARGUMENT_SEPARATOR);
        if (args.isBlank()) {
            return null;
        }
        return args.trim().split(ARGUMENT_SEPARATOR);
    }
    private void displayResult(CommandResult result) {
        if (result.message().isBlank()) {
            return;
        }
        if (result.type() == CommandResultType.SUCCESS) {
            System.out.println(result.message());
        } else {
            System.err.println(result.message());
        }
    }
    /**
     * Runs the CommandHandler.
     * The game loop starts.
     */
    public void runHandler() {
        Scanner scanner = new Scanner(System.in);
        while (running && scanner.hasNextLine()) {
            try {
                String input = scanner.nextLine();
                String command = getCommand(input);
                String[] args = getCommandArgs(command, input);
                CommandResult result = commands.get(command).execute(args);
                displayResult(result);
            } catch (InvalidArgumentException e) {
                System.err.println(e.getMessage());
            }

        }
    }
    /**
     * Quits the CommandHandler.
     * The game loop stops.
     * Does not de init the objects instance.
     */
    public void quit() {
        this.running = false;
    }
}
