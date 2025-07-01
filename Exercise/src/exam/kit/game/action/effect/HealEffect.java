package exam.kit.game.action.effect;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.MalformedEffectException;

/**
 * Represents a heal effect that can be applied by an action.
 * @author uepiy
 */

public class HealEffect implements Effect {
    private final int hitRate;
    private final Target target;
    private final StrengthType strengthType;
    private final int strength;

    /**
     * Creates a new heal effect.
     * @param parameters array of parameters for the effect
     *                   parameters[0] the target of the effect
     *                   parameters[1] the strength type of the effect
     *                   parameters[2] the strength of the effect
     *                   parameters[3] the hit rate of the effect
     *                   The parameters must be in the correct order and format.
     * @throws MalformedEffectException if the parameters are invalid
     */
    public HealEffect(String[] parameters) throws MalformedEffectException {
        if (parameters.length != 4) {
            throw new MalformedEffectException("Invalid heal effect parameters.");
        }
        try {
            this.target = Target.damageHealTarget(parameters[0]);
            this.strengthType = StrengthType.fromString(parameters[1]);
            this.strength = Integer.parseInt(parameters[2]);
            this.hitRate = Integer.parseInt(parameters[3]);
        } catch (NumberFormatException e) {
            throw new MalformedEffectException("Invalid heal effect parameters.");
        } catch (InvalidArgumentException e) {
            throw new MalformedEffectException(e.getMessage());
        }

    }
    /**
     * Returns the strength type of the effect.
     * @return the strength type of the effect
     */
    public Target getTarget() {
        return target;
    }
    /**
     * Returns the strength type of the effect.
     * @return the strength type of the effect
     */
    public StrengthType getStrengthType() {
        return strengthType;
    }
    /**
     * Returns the strength of the effect.
     * @return the strength of the effect
     */
    public int getStrength() {
        return this.strength;
    }
    @Override
    public int getHitRate() {
        return this.hitRate;
    }
}
