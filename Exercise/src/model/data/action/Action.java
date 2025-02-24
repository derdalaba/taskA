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

    public Action(String head, List<Effect> effectList) {
        String[] headParts = head.split(ARGUMENT_SEPARATOR);
        this.type = parseType(headParts[TYPE_INDEX]);
        this.name = headParts[NAME_INDEX];
        this.effectList = effectList;
    }
    private Type parseType(String type) {
        return Type.valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return name;
    }
}
