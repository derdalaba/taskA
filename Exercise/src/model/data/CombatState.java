package model.data;

import model.data.monster.CombatMonster;
import model.data.monster.Monster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombatState {
    private static final String MULTIPLE_MONSTER_SUFFIX = "#";
    private Map<String, CombatMonster> combatMonsterMap;

    public CombatState(List<Monster> monsters) {
        this.combatMonsterMap = new HashMap<>();
        addMonsters(monsters);
    }
    private void addMonsters(List<Monster> monsters) {
        for (int id = 1; id <= monsters.size(); id++) {
            String monsterName = monsters.get(id).getName();
            if (combatMonsterMap.containsKey(monsterName)) {
                monsterName += MULTIPLE_MONSTER_SUFFIX + id;
            }
            combatMonsterMap.put(monsterName, new CombatMonster(monsters.get(id), id));
        }
    }
}
