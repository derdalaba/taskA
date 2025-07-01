package exam.kit.game.action.effect;

import exam.kit.exceptions.InvalidArgumentException;

/**
 * Represents a strength type that can be owned by a damage effect.
 * @author uepiy
 */

public enum StrengthType {
    /**
     * Represents that the strength is based on the both the attacker and the defender.
     */
    BASE,
    /**
     * Represents that the strength is a percentage of the defenders maxHp.
     */
    RELATIVE,
    /**
     * Represents that the strength is an absolute value.
     */
    ABSOLUTE;
    /**
     * Gets the strength type from a string.
     * @param strengthType the strength type as a string
     * @return the strength type
     * @throws InvalidArgumentException if the strength type is invalid
     */
    public static StrengthType fromString(String strengthType) throws InvalidArgumentException {
        return switch (strengthType) {
            case "BASE" -> BASE;
            case "RELATIVE" -> RELATIVE;
            case "ABSOLUTE" -> ABSOLUTE;
            default -> throw new InvalidArgumentException("Invalid strength type.");
        };
    }
}
