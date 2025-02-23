package model.data.action.effect;

import java.util.Random;

public class AbsoluteCount implements Count {
    private final int value;

    public AbsoluteCount(int value) {
        this.value = value;
    }
    public boolean hit(Random r) {
        return false;
    }
}
