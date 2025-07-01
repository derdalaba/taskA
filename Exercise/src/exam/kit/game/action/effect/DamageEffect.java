package exam.kit.game.action.effect;

import exam.kit.exceptions.MalformedEffectException;


/**
 * Represents a damage effect that can be owned by an action.
 * @author uepiy
 */

public class DamageEffect implements Effect {
    private final int strength;
    private final StrengthType strengthType;
    private final Target target;
    private final int hitRate;

    /**
     * Creates a new damage effect.
     * @param parameters array of parameters for the effect
     *                   0: the target of the effect
     *                   1: the strength of the effect
     *                   2: the strength type of the effect
     *                   3: the hit rate of the effect
     * @throws MalformedEffectException if the parameters are invalid
     */
    public DamageEffect(String[] parameters) throws MalformedEffectException {
        if (parameters.length != 4) {
            throw new MalformedEffectException("Invalid damage effect parameters.");
        }
        try {
            this.target = Target.protectTarget(parameters[0]);
            this.strength = Integer.parseInt(parameters[1]);
            this.strengthType = StrengthType.valueOf(parameters[2]);
            this.hitRate = Integer.parseInt(parameters[3]);
        } catch (NumberFormatException e) {
            throw new MalformedEffectException("Invalid damage effect parameters.");
        }
    }
    @Override
    public int getHitRate() {
        return hitRate;
    }
    /**
     * Returns the strength type of the effect.
     * @return the strength type of the effect
     */
    public StrengthType getStrengthType() {
        return strengthType;
    }
    /**
     * Returns the strength/damage amount of the effect.
     * @return the strength of the effect
     */
    public int getStrength() {
        return strength;
    }
    /**
     * Returns the target of the effect.
     * @return the target of the effect
     */
    public Target getTarget() {
        return target;
    }
}
