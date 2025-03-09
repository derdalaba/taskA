package model.data.action.effect;

import java.util.List;

public class HealEffect implements HitRateEffect {
    private final TargetMonster targetMonster;
    private final StrengthType strengthType;
    private final int hitRate;

    public HealEffect(List<String> effectParameters) {
        this.targetMonster = parseMonsterTarget(effectParameters.get(0));
        this.strengthType = parseStrengthType(effectParameters.get(1));
        this.hitRate = Integer.parseInt(effectParameters.get(2));
    }
    @Override
    public int getHitRate() {
        return hitRate;
    }
    @Override
    public boolean isHit() {
        return false;
    }
}
