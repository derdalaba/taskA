package model;

import model.data.CombatState;
import model.data.Monster;

import java.util.List;

public class Model {
    private List<Monster> monsters;
    private CombatState combatState;

    public Model(List<Monster> monsters) {
        this.monsters = monsters;
    }
    public initCombat(List<Monster> monsters) {
        this.combatState = new CombatState(monsters);
    }
}
