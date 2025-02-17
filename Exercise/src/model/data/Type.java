package model.data;

/**
 * Enum class for the monster's type.
 * The types are FIRE, WATER, EARTH, and NORMAL
 * @author uepiy
 */

public enum Type {
    /**
     * Fire is strong against earth.
     */
    FIRE,
    /**
     * Water is strong against fire.
     */
    WATER,
    /**
     * Earth is strong against water.
     */
    EARTH,
    /**
     * Normal is neutral against all types.
     */
    NORMAL
}
