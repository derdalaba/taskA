package model;

import model.data.action.Action;
import model.data.CombatState;
import model.data.monster.Monster;
import views.terminal.exceptions.MonstersNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    private static final String MONSTER_NOT_FOUND = "Monster not found";
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
    public void startCompetition(List<String> monsters) throws MonstersNotFoundException {
        List<Monster> monstersList = new ArrayList<>();
        try {
            for (String monster : monsters) {
                monstersList.add(this.monsters.get(monster));
            }
        } catch (NullPointerException e) {
            throw new MonstersNotFoundException(MONSTER_NOT_FOUND);
        }
        this.combatState = new CombatState(monstersList);
    }
}
