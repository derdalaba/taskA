package exam.kit.game.action.effect;

import exam.kit.exceptions.MalformedEffectException;

/**
 * Represents a protect effect that can be applied by an action.
 * @author uepiy
 */

public class ProtectEffect implements Effect {
    private static final int MINIMUM_PARAMETERS = 3;
    private static final int MAXIMUM_PARAMETERS = 5;
    private final int hitRate;
    private final Target target;
    private final Count count;
    /**
     * Creates a new protect effect with the given hit rate.
     * @param parameters list of parameters for the effect
     * @throws MalformedEffectException if the parameters are invalid
     */
    public ProtectEffect(String[] parameters) throws MalformedEffectException {
        if (parameters.length != MINIMUM_PARAMETERS && parameters.length != MAXIMUM_PARAMETERS) {
            throw new MalformedEffectException("Invalid heal effect parameters.");
        }
        this.target = Target.protectTarget(parameters[0]);
        if (parameters.length == 3) {
            this.count = new AbsolutCount(parameters[1]);
            this.hitRate = Integer.parseInt(parameters[2]);

        } else {
            this.hitRate = Integer.parseInt(parameters[4]);
            this.count = new RandomCount(parameters[2], parameters[3]);
        }
    }

    @Override
    public int getHitRate() {
        return hitRate;
    }
}
