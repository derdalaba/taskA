package exam.kit.game;

import exam.kit.exceptions.InvalidArgumentException;

import java.util.Random;

import static exam.kit.util.system.DebugIo.getDebugDecisionBool;
import static exam.kit.util.system.DebugIo.getDebugDecisionDouble;

/**
 * Generates random numbers.
 * This is used for random events in the game.
 * @author uepiy
 */

public class NumberGenerator {
    private static final String INVALID_SEED = "Invalid seed";
    private static final String VALID_GENERATOR_REGEX = "([0-9]+|Debug)";
    private Random generator;
    /**
     * Creates a new number generator.
     * @param arg the seed for the generator or "Debug" for debug mode
     * @throws InvalidArgumentException if the seed is invalid or does not match "Debug"
     */
    public NumberGenerator(String arg) throws InvalidArgumentException {
        if (arg == null || !arg.matches(VALID_GENERATOR_REGEX)) {
            throw new InvalidArgumentException(INVALID_SEED);
        } else if (arg.equals("Debug")) {
            generator = null;
        }
        generator = new Random(Integer.parseInt(arg));
    }
    /**
     * Returns the result of a random decision for effect hits, crits and end of status conditions.
     * @param limit the threshold for the decision
     * @param debugMessage the message for debug mode
     * @return the result of the decision
     */
    public boolean getHitCritStatCond(double limit, String debugMessage) {
        if (generator == null) {
            return getDebugDecisionBool(debugMessage);
        }
        return generator.nextDouble() < limit;
    }
    /**
     * Returns the result of a random decision for damage factors.
     * @param debugMessage the message for debug mode
     * @return the result of the decision
     */
    public double getDamageFactor(String debugMessage) {
        if (generator == null) {
            return getDebugDecisionDouble(debugMessage, 0.85, 1.0);
        }
        return generator.nextDouble(0.85, 1.0);
    }
}
