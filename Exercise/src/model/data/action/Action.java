package model.data.action;

public class Action {
    private final String name;
    private final Effect effect;

    public Action(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    @Override
    public String toString() {
        return name;
    }
}
