package model.data.monster;

import model.data.action.Action;
import model.data.shared.State;
import model.data.shared.Type;

import java.util.List;

public class Monster {
    private final String name;
    private final BaseState baseState;
    private final Type type;
    private State state;
    private List<Action> actions;

    public Monster(String name, BaseState baseState, Type type, List<Action> actions) {
        this.name = name;
        this.baseState = baseState;
        this.type = type;
        this.state = State.UNAFFECTED;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }
}
