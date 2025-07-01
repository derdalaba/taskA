package exam.kit.game.action.effect;

import exam.kit.exceptions.MalformedEffectException;

/**
 * Represents a continue effect that can be applied by an action.
 * @author uepiy
 */

public class ContinueEffect implements Effect {
    private static final String INVALID_PARAMS_MESSAGE = "Invalid continue effect parameters.";
    private final int hitRate;
    /**
     * Creates a new continue effect.
     * @param effectParameters array of parameters for the effect
     *                         0: the hit rate of the effect
     * @throws MalformedEffectException if the parameter is not a number
     */
    public ContinueEffect(String[] effectParameters) throws MalformedEffectException {
        if (effectParameters.length != 1) {
            throw new MalformedEffectException(INVALID_PARAMS_MESSAGE);
        }
        try {
            this.hitRate = Integer.parseInt(effectParameters[0]);
        } catch (NumberFormatException e) {
            throw new MalformedEffectException(INVALID_PARAMS_MESSAGE);
        }
    }
    @Override
    public int getHitRate() {
        return hitRate;
    }
}
