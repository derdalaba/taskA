package exam.kit.game;


import exam.kit.game.action.Action;

import java.util.List;

/**
 * Represents a monster template.
 * The template is used to create a monster for combat.
 * Constructed from a configuration file.
 * @param name name of the monster
 * @param type element type of the monster
 * @param baseState base state of the monster
 * @param actionList list of actions the monster can perform
 * @author uepiy
 */

public record MonsterTemplate(String name, Element type, BaseState baseState, List<Action> actionList) {
    @Override
    public boolean equals(Object o) {
        if (o instanceof MonsterTemplate other) {
            return this.name().equals(other.name());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name().hashCode();
    }
}
