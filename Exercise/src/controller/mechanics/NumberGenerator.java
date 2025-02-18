package controller.mechanics;

import java.util.Random;

public class NumberGenerator {
    private final int seed;
    private Random random;

    public NumberGenerator(int seed) {
        this.seed = seed;
        this.random = new Random(seed);
    }
}
