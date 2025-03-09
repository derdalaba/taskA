package model.data.action.effect;

import model.data.shared.Stat;

import java.util.List;

public class StatusChange implements HitRateEffect {
    private final TargetMonster target;
    private final Stat stat;
    private final int hitRate;
    public StatusChange(List<String> effect) {
        this.target = parseMonsterTarget(effect.get(0));
        this.stat = Stat.valueOf(effect.get(1));
        this.hitRate = Integer.parseInt(effect.get(2));
    }

    @Override
    public boolean isHit() {
        return false;
    }

    @Override
    public int getHitRate() {
        return hitRate;
    }
}
