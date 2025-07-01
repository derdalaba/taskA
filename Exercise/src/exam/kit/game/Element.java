package exam.kit.game;

import exam.kit.exceptions.InvalidArgumentException;

/**
 * Represents an elemental type.
 * @author uepiy
 */

public enum Element {
    /**
     * Represents the fire element.
     */
    FIRE,
    /**
     * Represents the water element.
     */
    WATER,
    /**
     * Represents the earth element.
     */
    EARTH,
    /**
     * Represents the normal/no element.
     */
    NORMAL;

    /**
     * Checks if the given string is a valid element.
     * @param word the string to check
     * @return true if the string is a valid element, false otherwise
     */
    public static boolean contains(String word) {
        for (Element element : Element.values()) {
            if (element.name().equals(word)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Gets the element from a string.
     * @param element the element as a string
     * @return the element
     * @throws InvalidArgumentException if the element is invalid
     */
    public static Element fromString(String element) throws InvalidArgumentException {
        return switch (element) {
            case "FIRE" -> FIRE;
            case "WATER" -> WATER;
            case "EARTH" -> EARTH;
            case "NORMAL" -> NORMAL;
            default -> throw new InvalidArgumentException("Invalid element: " + element);
        };
    }
    /**
     * Gets the effectiveness of the element against another element.
     * @param element the element to check against
     * @return the effectiveness of the element against the other element
     */
    public Effectiveness getEffectiveness(Element element) {
        return switch (this) {
            case FIRE -> switch (element) {
                case FIRE, NORMAL -> Effectiveness.NORMAL;
                case WATER -> Effectiveness.WEAK;
                case EARTH -> Effectiveness.STRONG;
            };
            case WATER -> switch (element) {
                case FIRE -> Effectiveness.STRONG;
                case WATER, NORMAL -> Effectiveness.NORMAL;
                case EARTH -> Effectiveness.WEAK;
            };
            case EARTH -> switch (element) {
                case FIRE -> Effectiveness.WEAK;
                case WATER -> Effectiveness.STRONG;
                case EARTH, NORMAL -> Effectiveness.NORMAL;
            };
            case NORMAL -> Effectiveness.NORMAL;
        };

    }
}
