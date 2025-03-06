package model.data.action.effect;

import java.util.List;

public class ContinueEffect implements HitRateEffect {
    private final int hitRate;

    public ContinueEffect(List<String> effectParameters) {
        this.hitRate = Integer.parseInt(effectParameters.get(0));
    }
    @Override
    public boolean isHit() {
        return false;
    }
}
