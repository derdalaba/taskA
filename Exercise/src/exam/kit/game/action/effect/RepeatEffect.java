package exam.kit.game.action.effect;

import java.util.List;

/**
 * Represents a repeat effect that can be owned by an action.
 * @author uepiy
 */

public class RepeatEffect implements Effect {
    private final Count count;
    private final List<Effect> effects;

    /**
     * Creates a new repeat effect.
     * @param count the count of repetitions
     * @param effects the effects to repeat
     */
    public RepeatEffect(Count count, List<Effect> effects) {
        this.count = count;
        this.effects = effects;
    }
    /**
     * Returns the count of repetitions.
     * @return the count of repetitions
     */
    public Count getCount() {
        return count;
    }
    /**
     * Returns the effects to repeat.
     * @return the effects to repeat
     */
    public List<Effect> getEffects() {
        return effects;
    }
    @Override
    public int getHitRate() {
        return 0;
    }
}
