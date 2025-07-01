package exam.kit.game;

/**
 * Represents the base state of a monster.
 * @param maxHp the maximum and initial hit points of the monster.
 * @param atk base attack strength of the monster.
 * @param def base defense strength of the monster.
 * @param spd base speed of the monster.
 * @author uepiy
 */
public record BaseState(int maxHp, int atk, int def, int spd) {
}
