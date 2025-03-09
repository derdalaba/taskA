package model.data.shared;

/**
 * Enum class for the state condition a monster can be in.
 * The states are WET, BURN, QUICKSAND, and SLEEP.
 * The states can end in each round by a chance of 1/3.
 * @author uepiy
 */

public enum StateCondition {
    /**
     * The normal state of a monster.
     */
    UNAFFECTED,
    /**
     * The wet state effects the monster's defense.
     * -25% defense.
     */
    WET,
    /**
     * The burn state effects the monster's health and attack.
     * -25% attack.
     * -10% health per action.
     */
    BURN,
    /**
     * The quicksand state effects the monster's speed.
     * -25% speed.
     */
    QUICKSAND,
    /**
     * The sleep state effects the monster's ability to act.
     * The monster cannot act.
     */
    SLEEP
}
