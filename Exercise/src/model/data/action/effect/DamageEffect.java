package model.data.action.effect;

import java.util.List;

public class DamageEffect implements Effect {
    private static final String TARGET_MONSTER_USER = "user";
    private static final String TARGET_MONSTER_OTHER = "target";
    private static final String STRENGTH_TYPE_BASE = "base";
    private static final String STRENGTH_TYPE_RELATIVE = "rel";
    private static final String STRENGTH_TYPE_ABSOLUTE = "abs";

    private final TargetMonster target;
    private final StrengthType strengthType;
    private final int strength;
    private final int hitRate;

    public DamageEffect(List<String> effect) {
        this.target = parseTarget(effect.get(0));
        this.strengthType = parseStrengthType(effect.get(1));
        this.strength = Integer.parseInt(effect.get(2));
        this.hitRate = Integer.parseInt(effect.get(3));
    }
    private TargetMonster parseTarget(String target) {
        return switch (target) {
            case TARGET_MONSTER_USER -> TargetMonster.USER;
            case TARGET_MONSTER_OTHER -> TargetMonster.TARGET;
            default -> throw new IllegalArgumentException("Invalid target: " + target);
        };
    }
    private StrengthType parseStrengthType(String strengthType) {
        return switch (strengthType) {
            case STRENGTH_TYPE_BASE -> StrengthType.BASE;
            case STRENGTH_TYPE_RELATIVE -> StrengthType.RELATIVE;
            case STRENGTH_TYPE_ABSOLUTE -> StrengthType.ABSOLUTE;
            default -> throw new IllegalArgumentException("Invalid strength type: " + strengthType);
        };
    }
}
