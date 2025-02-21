package model;

import model.data.action.Action;
import model.data.CombatState;
import model.data.monster.Monster;

import java.util.HashMap;
import java.util.List;

public class Model {
    private HashMap<String, Monster> monsters;
    private HashMap<String, Action> actions;
    private CombatState combatState;

    public Model(List<Monster> monsters, List<Action> actions) {
        for (Monster monster : monsters) {
            this.monsters.put(monster.getName(), monster);
        }
        for (Action action : actions) {
            this.actions.put(action.toString(), action);
        }
    }
    public void initCombat(List<Monster> monsters) {
        this.combatState = new CombatState(monsters);
    }
}
