package exam.kit.game.action.effect;

import exam.kit.exceptions.MalformedEffectException;
import exam.kit.game.combat.StatusType;

/**
 * Represents a status change effect that can be applied by an action.
 * @author uepiy
 */

public class StatusChangeEffect implements Effect {
    private final int hitRate;
    private final Target target;
    private final StatusType statusToChange;
    private final boolean direction;
    /**
     * Creates a new status change effect.
     * @param parameters list of parameters for the effect
     *                   0: the target of the effect
     *                   1: the status to change
     *                   2: the direction of the change
     *                   3: the hit rate of the effect
     * @throws MalformedEffectException if the parameters are invalid
     */
    public StatusChangeEffect(String[] parameters) throws MalformedEffectException {
        this.target = Target.protectTarget(parameters[0]);
        this.statusToChange = checkStatus(parameters[1]);
        this.direction = Boolean.parseBoolean(parameters[2]);
        this.hitRate = Integer.parseInt(parameters[3]);
    }
    private static StatusType checkStatus(String status) throws MalformedEffectException {
        if (status.equals("ATK") || status.equals("DEF") || status.equals("SPD") || status.equals("PRC") || status.equals("AGL")) {
            return StatusType.valueOf(status);
        } else {
            throw new MalformedEffectException("Invalid status change effect parameters.");
        }
    }
    /**
     * Returns the status to change.
     * @return the status to change
     */
    public StatusType getStatusToChange() {
        return statusToChange;
    }
    /**
     * Returns the direction of the change.
     * @return the direction of the change
     *      true if the status is increased, false if the status is decreased
     */
    public boolean getDirection() {
        return direction;
    }
    /**
     * Returns the target of the effect.
     * @return the target of the effect
     */
    public Target getTarget() {
        return target;
    }

    @Override
    public int getHitRate() {
        return hitRate;
    }
}
