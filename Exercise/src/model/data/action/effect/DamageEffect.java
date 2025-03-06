package model.data.action.effect;

import java.util.List;

public class DamageEffect implements HitRateEffect {
    private final TargetMonster target;
    private final StrengthType strengthType;
    private final int strength;
    private final int hitRate;

    public DamageEffect(List<String> effect) {
        this.target = parseMonsterTarget(effect.get(0));
        this.strengthType = parseStrengthType(effect.get(1));
        this.strength = Integer.parseInt(effect.get(2));
        this.hitRate = Integer.parseInt(effect.get(3));
    }

    @Override
    public boolean isHit() {
        return false;
    }
}
