package model.data.action;

import model.data.action.effect.Effect;
import model.data.shared.Type;

import java.util.List;

public class Action {
    private static final String ARGUMENT_SEPARATOR = " ";
    private static final int TYPE_INDEX = 2;
    private static final int NAME_INDEX = 1;
    private final String name;
    private final Type type;
    private final List<Effect> effectList;

    public Action(String name, String type, List<Effect> effectList) {
        this.type = Type.valueOf(type);
        this.name = name;
        this.effectList = effectList;
    }

    @Override
    public String toString() {
        return name;
    }
}
