package exam.kit.game.action.effect;

import exam.kit.exceptions.MalformedEffectException;

/**
 * Represents a target that can be owned by an effect.
 * @author uepiy
 */

public enum Target {
    /**
     * Represents the user of the action as a damage target.
     */
    USER,
    /**
     * Represents the damage target of the action as another entity.
     */
    TARGET,
    /**
     * Represents the health of the user as protect target.
     */
    HEALTH,
    /**
     * Represents the stats of the user as protect target.
     */
    STATS;
    /**
     * Parses a string to a damage target.
     * @param target target of the effect
     * @return the target of the effect
     * @throws MalformedEffectException if the target is invalid
     */
    public static Target damageHealTarget(String target) throws MalformedEffectException {
        return switch (target) {
            case "user" -> USER;
            case "target" -> TARGET;
            default -> throw new MalformedEffectException("Invalid target: " + target);
        };
    }
    /**
     * Parses a string to a protect target.
     * @param target target of the effect
     * @return the target of the effect
     * @throws MalformedEffectException if the target is invalid
     */
    public static Target protectTarget(String target) throws MalformedEffectException {
        return switch (target) {
            case "health" -> HEALTH;
            case "stats" -> STATS;
            default -> throw new MalformedEffectException("Invalid target: " + target);
        };
    }
}
