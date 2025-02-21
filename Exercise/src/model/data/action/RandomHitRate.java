package model.data.action;

public class RandomHitRate implements HitRate {
    private final int min;
    private final int max;

    public RandomHitRate(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
