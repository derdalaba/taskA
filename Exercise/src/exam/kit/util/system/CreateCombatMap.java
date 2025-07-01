package exam.kit.util.system;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.game.MonsterTemplate;
import exam.kit.game.combat.Monster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Utility class for creating combat monster HashMaps.
 * @author uepiy
 */

public final class CreateCombatMap {
    private static final String DUPLICATE_NAME_SUFFIX = "#";
    private static final String INVALID_MONSTER_NAME = "Invalid monster name.";
    private static final int BASE_COUNT = 1;
    private static final int COUNT_INCREMENT = 1;
    private CreateCombatMap() {
    }
    /**
     * Returns a list of MonsterTemplates from a list of monster names.
     * @param args list of monster names
     * @param allMonsters list of all MonsterTemplates
     * @return list of MonsterTemplates
     * @throws InvalidArgumentException if an invalid monster name is in the list. Monster name must be in allMonsters.
     */
    public static List<MonsterTemplate> getMonsterList(String[] args, List<MonsterTemplate> allMonsters) throws InvalidArgumentException {
        List<MonsterTemplate> monsterTemplateList = new ArrayList<>();
        for (String arg : args) {
            for (MonsterTemplate monsterTemplate : allMonsters) {
                if (monsterTemplate.name().equals(arg)) {
                    monsterTemplateList.add(monsterTemplate);
                    break;
                }
            }
        }
        if (monsterTemplateList.size() != args.length) {
            throw new InvalidArgumentException(INVALID_MONSTER_NAME);
        }
        return monsterTemplateList;
    }
    /**
     * Returns a map of monster names to whether they are only occurring once or more times.
     * @param monsterTemplateList list of MonsterTemplates
     * @return map of monster names to whether they are only occurring once or more times
     */
    public static HashMap<String, Boolean> getIsSingle(List<MonsterTemplate> monsterTemplateList) {
        HashMap<String, Boolean> monsterSingle = new HashMap<>();
        for (MonsterTemplate monster : monsterTemplateList) {
            if (!monsterSingle.containsKey(monster.name())) {
                monsterSingle.put(monster.name(), true);
            } else {
                monsterSingle.put(monster.name(), false);
            }
        }
        return monsterSingle;
    }
    /**
     * Creates a map of monster names to Monster objects.
     * @param monsterTemplateList list of MonsterTemplates
     * @param monsterSingle map of monster names identifying whether they are only occurring once or more times
     * @return map of monster names to Monster objects
     */
    public static HashMap<String, Monster> createMonsterMap(List<MonsterTemplate> monsterTemplateList,
                                                            HashMap<String, Boolean> monsterSingle) {
        HashMap<String, Integer> nameIndices = new HashMap<>();
        HashMap<String, Monster> monsterMap = new HashMap<>();
        for (MonsterTemplate monsterTemplate : monsterTemplateList) {
            String monsterName = monsterTemplate.name();
            if (monsterSingle.get(monsterName)) {
                monsterMap.put(monsterName, new Monster(monsterTemplate));
            } else {
                if (!nameIndices.containsKey(monsterName)) {
                    nameIndices.put(monsterName, BASE_COUNT);
                } else {
                    nameIndices.put(monsterName, nameIndices.get(monsterName) + COUNT_INCREMENT);
                }
                monsterMap.put(monsterName + DUPLICATE_NAME_SUFFIX + COUNT_INCREMENT, new Monster(monsterTemplate));
            }
        }
        return monsterMap;
    }
}
