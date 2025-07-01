package exam.kit.game.action.effect;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.MalformedEffectException;
import exam.kit.game.combat.StatusCondition;

/**
 * Represents a status condition effect that can be applied by an action.
 * It effects the status condition of the monster in combat.
 * @author uepiy
 */

public class StatusConditionEffect implements Effect {
    private final int hitRate;
    private final StatusCondition statusCondition;
    private final Target target;

    /**
     * Creates a new status condition effect.
     * @param parameters array of parameters for the effect
     * @throws MalformedEffectException if the effect is malformed
     */
    public StatusConditionEffect(String[] parameters) throws MalformedEffectException {
        try {
            this.hitRate = Integer.parseInt(parameters[2]);
            this.statusCondition = StatusCondition.fromString(parameters[1]);
            this.target = Target.protectTarget(parameters[0]);
        } catch (NumberFormatException e) {
            throw new MalformedEffectException("Invalid hit rate.");
        } catch (InvalidArgumentException e) {
            throw new MalformedEffectException(e.getMessage());
        }

    }
    /**
     * Returns the hit rate of the effect.
     * @return the hit rate of the effect
     */
    public int getHitRate() {
        return hitRate;
    }
    /**
     * Returns the target of the effect.
     * @return the target of the effect
     */
    public Target getTarget() {
        return target;
    }
    /**
     * Gets the status condition of the effect it will apply.
     * @return the status condition of the effect
     */
    public StatusCondition getStatusCondition() {
        return statusCondition;
    }
}
