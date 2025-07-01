package exam.kit.game.action.effect;

/**
 * Represents the count of repetitions of an effect or number of active rounds.
 * In range of min and max values, the count is randomly selected.
 * @author uepiy
 */

public class RandomCount implements Count {
    private final int min;
    private final int max;
    /**
     * Creates a new random count with the given minimum and maximum values.
     * @param parameters list of parameters for the count
     */
    public RandomCount(String[] parameters) {
        this.min = Integer.parseInt(parameters[0]);
        this.max = Integer.parseInt(parameters[1]);
    }
    /**
     * Creates a new random count with the given minimum and maximum values.
     * @param min the minimum value of the count
     * @param max the maximum value of the count
     */
    public RandomCount(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }
    /**
     * Returns the minimum value of the count.
     * @return the minimum value of the count
     */
    public int getMin() {
        return min;
    }
    /**
     * Returns the maximum value of the count.
     * @return the maximum value of the count
     */
    public int getMax() {
        return max;
    }
}
