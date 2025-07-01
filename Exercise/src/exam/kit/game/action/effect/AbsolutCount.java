package exam.kit.game.action.effect;

/**
 * Represents the absolut count of repetitions of an effect or number of active rounds.
 * @author uepiy
 */

public class AbsolutCount implements Count {
    private final int count;
    /**
     * Creates a new absolut count.
     * @param count the count of repetitions or active rounds
     */
    public AbsolutCount(String count) {
        this.count = Integer.parseInt(count);
    }
    /**
     * Returns the count of repetitions or active rounds.
     * @return the count of repetitions or active rounds
     */
    public int getCount() {
        return count;
    }
}
