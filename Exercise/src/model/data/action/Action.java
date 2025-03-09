package model.data.action;

import model.data.action.effect.*;
import model.data.shared.Type;

import java.util.List;

public class Action {
    private static final String ARGUMENT_SEPARATOR = " ";
    private static final String NAME_SEPARATOR = ": ";
    private static final String ELEMENT_FIELD_PREFIX = "ELEMENT";
    private static final String DAMAGE_EFFECT = "Damage";
    private static final String NO_DAMAGE = "--";
    private static final String FIELD_SEPARATOR = ", ";
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

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(NAME_SEPARATOR);
        stringBuilder.append(ELEMENT_FIELD_PREFIX).append(type);
        stringBuilder.append(DAMAGE_EFFECT);
        Effect firstEffect = effectList.get(0);
        if (firstEffect instanceof DamageEffect damageEffect) {
            switch (damageEffect.getStrengthType()) {
                case BASE -> stringBuilder.append("b");
                case ABSOLUTE -> stringBuilder.append("a");
                case RELATIVE -> stringBuilder.append("r");
            }
            stringBuilder.append((damageEffect).getStrength());
        } else {
            stringBuilder.append(NO_DAMAGE);

        }
        stringBuilder.append(FIELD_SEPARATOR);
        stringBuilder.append("HitRate");
        if (firstEffect instanceof RepeatEffect repeatEffect) {
            stringBuilder.append(repeatEffect.getFirstEffect().getHitRate());
        }
        return stringBuilder.toString();
    }
}
