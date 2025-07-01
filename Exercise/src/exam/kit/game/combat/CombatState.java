package exam.kit.game.combat;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.game.MonsterTemplate;
import exam.kit.game.action.Action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static exam.kit.util.system.CreateCombatMap.getIsSingle;
import static exam.kit.util.system.CreateCombatMap.getMonsterList;
import static exam.kit.util.system.CreateCombatMap.createMonsterMap;


/**
 * Represents the state of combat.
 * Contains the monsters that are currently in combat.
 * @author uepiy
 */

public class CombatState {
    private final HashMap<String, Monster> monsterMap;
    private HashMap<String, Action> nextActionMap;
    private CombatPhase phase;
    private String currentMonster;
    private Iterator<String> monsterIterator;
    /**
     * Constructs a CombatState object from the specified arguments.
     * @param args names of monsters to add to combat
     * @param allMonsters list of all monsterTemplates
     * @throws InvalidArgumentException if the monster names are not valid
     */
    public CombatState(String[] args, List<MonsterTemplate> allMonsters) throws InvalidArgumentException {
        List<MonsterTemplate> monsterTemplateList = getMonsterList(args, allMonsters);
        HashMap<String, Boolean> monsterSingle = getIsSingle(monsterTemplateList);
        this.monsterMap = createMonsterMap(monsterTemplateList, monsterSingle);
        this.nextActionMap = new HashMap<>();
        this.monsterIterator = monsterMap.keySet().iterator();
        this.phase = CombatPhase.PHASE_0;
    }
    private boolean advance() {
        if (phase == CombatPhase.PHASE_0) {
            if (combatOver()) {
                printWinner();
                return true;
            }
            phase = CombatPhase.PHASE_1;
            this.monsterIterator = monsterMap.keySet().iterator();
            currentMonster = monsterIterator.next();
            return false;
        } else if (phase == CombatPhase.PHASE_1 && !monsterIterator.hasNext()) {
            phase = CombatPhase.PHASE_2;
            calculatePhase2();
            phase = CombatPhase.PHASE_0;
            return advance();
        } else {
            currentMonster = monsterIterator.next();
            return false;
        }
    }
    private void printWinner() {
        for (Monster monster : monsterMap.values()) {
            if (monster.getStatus().getHp() > 0) {
                System.out.println(monster.getMonsterTemplate().name() + " has no opponents left and wins the competition!");
                return;
            }
        }
        System.out.println("All monsters have fainted. The competition ends without a winner!");
    }
    private boolean combatOver() {
        int count = 0;
        for (Monster monster : monsterMap.values()) {
            if (monster.getStatus().getHp() > 0) {
                count++;
            }
        }
        return count <= 1;
    }
    private void calculatePhase2() {
        //TIDO: Implement phase 2
    }
    /**
     * Sets the next action for the current monster.
     * @param args name of the action to set and its arguments
     * @return true if the combat is over, false otherwise
     * @throws InvalidArgumentException if the action name is not valid or the arguments are not valid
     */
    public boolean setAction(String[] args) throws InvalidArgumentException {
        String actionName = args[0];
        Action action = monsterMap.get(currentMonster).getAction(actionName);
        nextActionMap.put(currentMonster, action);
        return advance();
    }
    /**
     * Gets the action for the current monster.
     * @return action for the current monster
     */
    public List<Action> getActions() {
        return monsterMap.get(currentMonster).getMonsterTemplate().actionList();
    }
    /**
     * Gets the names of all monsters in combat.
     * @return list of monster names
     */
    public List<String> getMonsterNames() {
        return List.copyOf(monsterMap.keySet());
    }

}
