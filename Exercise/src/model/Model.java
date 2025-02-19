package model;

import model.data.Action;
import model.data.CombatState;
import model.data.Monster;

import java.util.List;

public class Model {
    private List<Monster> monsters;
    private List<Action> actions;
    private CombatState combatState;

    public Model(List<Monster> monsters, List<Action> actions) {
        this.monsters = monsters;
        this.actions = actions;
    }
    public void initCombat(List<Monster> monsters) {
        this.combatState = new CombatState(monsters);
    }
}
