package model.data.action.effect;

import java.util.List;

public class ProtectEffect implements HitRateEffect {
    private static final String TARGET_PROTECT_STATS = "stats";
    private static final String TARGET_PROTECT_HEALTH = "health";
    private final int hitRate;
    private final Count count;
    private final TargetProtect targetProtect;
    public ProtectEffect(List<String> effectParameters) {
        this.targetProtect = parseProtectTarget(effectParameters.get(0));
        this.count = count;
        this.hitRate = hitRate;
    }
    private TargetProtect parseProtectTarget(String target) {
        return switch (target) {
            case TARGET_PROTECT_STATS -> TargetProtect.STATS;
            case TARGET_PROTECT_HEALTH -> TargetProtect.HEALTH;
            default -> throw new IllegalArgumentException("Invalid target: " + target);
        };
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
