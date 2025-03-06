package model.data.action.effect;

import model.data.shared.State;

import java.util.List;

public class StatusConditionEffect implements HitRateEffect {
    private final TargetMonster targetMonster;
    private final State statusCondition;
    private final int hitRate;
    public StatusConditionEffect(List<String> effectParameters) {
        this.targetMonster = parseMonsterTarget(effectParameters.get(0));
        this.statusCondition = State.valueOf(effectParameters.get(1));
        this.hitRate = Integer.parseInt(effectParameters.get(2));
    }

    @Override
    public boolean isHit() {
        return false;
    }
}
