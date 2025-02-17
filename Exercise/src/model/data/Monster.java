package model.data;

public class Monster {
    private final String name;
    private final BaseState baseState;
    private final Type type;
    private State state;

    public Monster(String name, BaseState baseState, Type type) {
        this.name = name;
        this.baseState = baseState;
        this.type = type;
        this.state = State.NORMAL;
    }

}
