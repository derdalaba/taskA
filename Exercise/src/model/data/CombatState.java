package model.data;

import model.interaction.ModelInterface;

import java.util.List;

public class CombatState {
    private List<Monster> monsters;

    public CombatState(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
