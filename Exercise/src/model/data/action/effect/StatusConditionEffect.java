package model.data.action.effect;

import model.data.shared.StateCondition;

import java.util.List;

public class StatusConditionEffect implements HitRateEffect {
    private final TargetMonster targetMonster;
    private final StateCondition statusCondition;
    private final int hitRate;
    public StatusConditionEffect(List<String> effectParameters) {
        this.targetMonster = parseMonsterTarget(effectParameters.get(0));
        this.statusCondition = StateCondition.valueOf(effectParameters.get(1));
        this.hitRate = Integer.parseInt(effectParameters.get(2));
    }

    @Override
    public boolean isHit() {
        return false;
    }
}
