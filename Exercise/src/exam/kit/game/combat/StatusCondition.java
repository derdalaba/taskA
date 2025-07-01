package exam.kit.game.combat;

import exam.kit.exceptions.InvalidArgumentException;

/**
 * Represents a status condition that can be applied to a monster.
 * A status condition is only applicable in combat.
 * @author uepiy
 */

public enum StatusCondition {
    /**
     * NORMAL: The monster is in normal condition.
     */
    NORMAL,
    /**
     * WET: The monster has 25% less effective defense.
     */
    WET,
    /**
     * BURN: The monster has 25% less effective attack.
     * The monster takes 10% of its maximum hit points as damage every action.
     * Shield does not protect against this damage.
     */
    BURN,
    /**
     * QUICKSAND: The monster has 25% less effective speed.
     */
    QUICKSAND,
    /**
     * SLEEP: The monster cannot act.
     */
    SLEEP;
    /**
     * Gets the status condition from the string representation.
     * @param statusCondition the string representation of the status condition.
     * @return the status condition.
     * @throws InvalidArgumentException if the status condition is not found.
     */
    public static StatusCondition fromString(String statusCondition) throws InvalidArgumentException {
        return switch (statusCondition) {
            case "WET" -> WET;
            case "BURN" -> BURN;
            case "QUICKSAND" -> QUICKSAND;
            case "SLEEP" -> SLEEP;
            default -> throw new InvalidArgumentException("Invalid status condition: " + statusCondition);
        };
    }
}
