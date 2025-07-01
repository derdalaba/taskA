package exam.kit.game;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.InvalidCommandExecutionException;
import exam.kit.exceptions.MalformedConfigException;
import exam.kit.game.action.Action;
import exam.kit.game.combat.CombatState;


/**
 * Represents the system the command handler will interact with.
 * Contains the game state and the methods to interact with it.
 * @author uepiy
 */

public class Game {
    private static final String COMBAT_START_MESSAGE = "The %d monsters enter the competition!";
    private static final String COMBAT_NOT_STARTED = "Combat has not started yet.";
    private final NumberGenerator generator;
    private Config config;
    private CombatState combatState;
    /**
     * Creates a new game with the specified generator and config file.
     * @param generator the generator to use
     * @param file the config file to read from
     * @throws InvalidArgumentException if the generator is not valid
     * @throws MalformedConfigException if the config file is not formatted correctly
     */
    public Game(String generator, String file) throws InvalidArgumentException, MalformedConfigException {
        this.generator = new NumberGenerator(generator);
        this.config = new Config(file);
    }
    /**
     * Starts a combat with the specified monsters.
     * @param args names of the monsters to add to combat
     * @return the message to display
     * @throws InvalidArgumentException if the monster names are not valid
     */
    public String startCombat(String[] args) throws InvalidArgumentException {
        this.combatState = new CombatState(args, this.config.getMonsterTemplates());
        int numberOfCompetitors = this.combatState.getMonsterNames().size();
        return COMBAT_START_MESSAGE.formatted(numberOfCompetitors);
    }
    /**
     * Returns the random number generator used by the game.
     * @return the random number generator
     */
    public NumberGenerator getGenerator() {
        return generator;
    }
    /**
     * Returns the actions currently available in combat.
     * @return the actions available
     * @throws InvalidCommandExecutionException if the combat has not started yet
     */
    public String showActions() throws InvalidCommandExecutionException {
        if (this.combatState == null) {
            throw new InvalidCommandExecutionException(COMBAT_NOT_STARTED);
        }
        StringBuilder sb = new StringBuilder();
        for (Action action : this.combatState.getActions()) {
            sb.append(action).append("\n");
        }
        return sb.toString();
    }
}
