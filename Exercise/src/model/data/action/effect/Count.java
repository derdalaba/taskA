package model.data.action.effect;

import java.util.Random;

/**
 * trys to pack random and non-random hit rates into one class
 */

public interface Count {
    /**
     * Determines if the event happens.
     * @param r the random number generator
     * @return true if the event happens, false otherwise
     */
    boolean hit(Random r);
}
