package model.data.monster;

import model.data.action.Action;
import model.data.shared.StateCondition;
import model.data.shared.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monster {
    private final String name;
    private final BaseState baseState;
    private final Type type;
    private final Map<String, Action> actions;

    /**
     * Constructor for the Monster class.
     * @param name Name of the monster
     * @param baseState Base state of the monster
     * @param type Type of the monster
     * @param actions List of actions the monster can perform
     */
    public Monster(String name, BaseState baseState, Type type, List<Action> actions) {
        this.name = name;
        this.baseState = baseState;
        this.type = type;
        this.actions = new HashMap<>();
        actions.forEach(action -> this.actions.put(action.getName(), action));
    }

    /**
     * Copy constructor for the Monster class.
     * @param monster Monster to copy
     */
    public Monster(Monster monster) {
        this.name = monster.name;
        this.baseState = monster.baseState;
        this.type = monster.type;
        this.actions = monster.actions;
    }
    /**
     * Get the name of the monster.
     * @return name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * Check if the monsters are the same.
     * source: https://www.baeldung.com/java-equals-hashcode-contracts
     * @param other Monster to compare
     * @return true if the monsters are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Monster monster = (Monster) other;
        return name.equals(monster.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
