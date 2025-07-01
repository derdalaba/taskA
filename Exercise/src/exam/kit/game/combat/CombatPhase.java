package exam.kit.game.combat;

/**
 * Represents a phase in combat.
 * @author uepiy
 */

public enum CombatPhase {
    /**
     * In this phase, the system check if there are any monsters that are still alive.
     * if there are no monsters that are still alive, the combat ends and there is no winner.
     * if there is only one monster that is still alive, the combat ends and the winner is the monster that is still alive.
     */
    PHASE_0,
    /**
     * In this phase, the system takes the actions of the monsters to be performed in the current turn.
     * The order of the monsters action input is determined by the order by they were added to the combat.
     */
    PHASE_1,
    /**
     * In this phase, the system applies the effects of the actions to the monsters.
     * The order of the monsters is determined by their effective speed.
     * For each monster, the system adds the effects of the actions to a queue.
     * Then the system determines the status of the monster.
     * Then the system applies the effects in the queue to the monsters.
     */
    PHASE_2
}
