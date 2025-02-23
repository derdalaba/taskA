package model.data.action;

import model.data.action.effect.Effect;

import java.util.List;

public class Action {
    private final String name;
    private final List<Effect> effectMap;

    public Action(String name, List<Effect> effectMap) {
        this.name = name;
        this.effectMap = effectMap;
    }

    @Override
    public String toString() {
        return name;
    }
}
