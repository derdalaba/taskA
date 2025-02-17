package model.data;

/**
 * This record represents the base state of a monster.
 * @param maxHealth The maximum health of the monster.
 * @param atk The attack of the monster. This affects the damage dealt by the monster.
 * @param def The defense of the monster. This affects the damage taken by the monster.
 * @param spd The speed of the monster. This affects the order of the monster's turn in combat.
 */

public record BaseState(int maxHealth, int atk, int def, int spd) {
    private static final int PRC = 1;
    private static final int AGL = 1;

}
