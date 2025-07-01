package exam.kit;


import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.MalformedConfigException;
import exam.kit.game.Game;
import exam.kit.terminal.interaction.CommandHandler;

/**
 * The main class of the game.
 * This project is very rushed as I have gotten sick and have been unable to work on it.
 * All written in one day. Had a not working version of the game before. Was in config parsing stage.
 * It's not good.
 * @author uepiy
 */

public final class Main {
    private static final String INVALID_ARGUMENTS = "Invalid arguments.";
    private Main() {
    }
    /**
     * The main method of the game.
     * It is responsible for starting the game and handling the arguments.
     * @param args the arguments of the game
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new InvalidArgumentException(INVALID_ARGUMENTS);
            }
            Game game = new Game(args[1], args[0]);
            CommandHandler commandHandler = new CommandHandler(game);
            commandHandler.runHandler();
        } catch (InvalidArgumentException | MalformedConfigException e) {
            System.err.println(e.getMessage());
        }
    }
}
