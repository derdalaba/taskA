package model.data.action.effect;

import java.util.List;

public class RepeatEffect implements Effect {
    private final Count count;
    private final List<Effect> effects;

    public RepeatEffect(Count count, List<Effect> effects) {
        this.count = count;
        this.effects = effects;
    }
    public Effect getFirstEffect() {
        return effects.get(0);
    }

    @Override
    public int getHitRate() {
        return effects.get(0).getHitRate();
    }
}
