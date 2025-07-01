package exam.kit.util.system;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.exceptions.MalformedConfigException;
import exam.kit.game.BaseState;
import exam.kit.game.Element;
import exam.kit.game.MonsterTemplate;
import exam.kit.game.action.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Parses the configuration file and creates objects from the data.
 * The configuration file must be formatted as specified in the given assignment.
 * @author uepiy
 */

public final class ConfigParser {
    private static final String ARGUMENT_SEPARATOR = " ";
    private ConfigParser() {
    }
    /**
     * Parses the action lines and creates Action objects.
     * with the specified name, element and effect list.
     * @param configLines list of strings containing the config lines
     * @return map of action names to Action objects
     * @throws MalformedConfigException if the config file is not formatted correctly
     */
    public static HashMap<String, Action> parseActions(List<String> configLines) throws MalformedConfigException {
        List<List<String>> actionSections = getActionSections(configLines);
        HashMap<String, Action> actionMap = new HashMap<>();
        for (List<String> actionSection : actionSections) {
            Action action = parseAction(actionSection);
            if (action == null) {
                continue;
            }
            actionMap.put(action.name(), action);
        }
        return actionMap;
    }
    private static Action parseAction(List<String> actionSection) throws MalformedConfigException {
        if (actionSection.isEmpty()) {
            return null;
        }
        return ActionParser.parseAction(actionSection);
    }
    private static List<List<String>> getActionSections(List<String> configLines) throws MalformedConfigException {
        List<List<String>> actionSections = new ArrayList<>();
        while (true) {
            List<String> actionSection = new ArrayList<>();
            String currentLine = configLines.remove(  0);
            if (configLines.isEmpty()) {
                System.out.println("empty");
            }
            if (currentLine.startsWith("monster")) {
                break;
            }
            actionSections.add(actionSection);
        }
        return actionSections;
    }
    /**
     * Parses the monster lines and creates MonsterTemplate objects.
     * monster templates are used to create monsters in the game for combat.
     * @param configLines list of strings containing all config lines
     * @param actionMap map of action names to Action objects
     * @return map of monster names to MonsterTemplate objects
     * @throws MalformedConfigException if the config file is not formatted correctly
     */
    public static HashMap<String, MonsterTemplate> parseMonsters(List<String> configLines, HashMap<String, Action> actionMap)
            throws MalformedConfigException {
        List<MonsterTemplate> monsterTemplates = new ArrayList<>();
        do {
            String currentLine = configLines.remove(0);
            if (currentLine.isEmpty()) {
                continue;
            }
            monsterTemplates.add(parseMonster(currentLine, actionMap));
        } while (!configLines.isEmpty());
        return getMonsterMap(monsterTemplates);
    }
    private static HashMap<String, MonsterTemplate> getMonsterMap(List<MonsterTemplate> monsterTemplates) {
        HashMap<String, MonsterTemplate> monsterMap = new HashMap<>();
        for (MonsterTemplate monsterTemplate : monsterTemplates) {
            monsterMap.put(monsterTemplate.name(), monsterTemplate);
        }
        return monsterMap;
    }
    private static List<Action> getActionList(String[] actionNames, HashMap<String, Action> actionMap) throws MalformedConfigException {
        List<Action> actionList = new ArrayList<>();
        for (String actionName : actionNames) {
            if (!actionMap.containsKey(actionName)) {
                throw new MalformedConfigException("Invalid action name in monster section");
            }
            actionList.add(actionMap.get(actionName));
        }
        return actionList;
    }
    private static MonsterTemplate parseMonster(String monsterLine, HashMap<String, Action> actionMap) throws MalformedConfigException {
        String[] monsterParts = monsterLine.split(ARGUMENT_SEPARATOR);
        String monsterName = monsterParts[1];
        try {
            Element monsterElement = Element.fromString(monsterParts[2]);
            BaseState monsterBaseState = new BaseState(Integer.parseInt(monsterParts[3]), Integer.parseInt(monsterParts[4]),
                    Integer.parseInt(monsterParts[5]), Integer.parseInt(monsterParts[6]));
            List<Action> monsterActions = getActionList(Arrays.copyOfRange(monsterParts, 7, monsterParts.length), actionMap);
            return new MonsterTemplate(monsterName, monsterElement, monsterBaseState, monsterActions);
        } catch (InvalidArgumentException e) {
            throw new MalformedConfigException("Invalid element in monster section");
        }

    }
}
