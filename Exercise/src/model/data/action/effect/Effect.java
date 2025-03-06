package model.data.action.effect;

public interface Effect {
    String TARGET_MONSTER_USER = "user";
    String TARGET_MONSTER_OTHER = "target";
    String STRENGTH_TYPE_BASE = "base";
    String STRENGTH_TYPE_RELATIVE = "rel";
    String STRENGTH_TYPE_ABSOLUTE = "abs";

    default TargetMonster parseMonsterTarget(String target) {
        return switch (target) {
            case TARGET_MONSTER_USER -> TargetMonster.USER;
            case TARGET_MONSTER_OTHER -> TargetMonster.TARGET;
            default -> throw new IllegalArgumentException("Invalid target: " + target);
        };
    }
    default StrengthType parseStrengthType(String strengthType) {
        return switch (strengthType) {
            case STRENGTH_TYPE_BASE -> StrengthType.BASE;
            case STRENGTH_TYPE_RELATIVE -> StrengthType.RELATIVE;
            case STRENGTH_TYPE_ABSOLUTE -> StrengthType.ABSOLUTE;
            default -> throw new IllegalArgumentException("Invalid strength type: " + strengthType);
        };
    }
}
