package model.data.action.effect;

import java.util.Random;

public class RandomCount implements Count {
    private final int min;
    private final int max;

    public RandomCount(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public boolean hit(Random r) {
        return false;
    }
}
