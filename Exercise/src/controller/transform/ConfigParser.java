package controller.transform;

import model.Model;
import model.data.action.Action;
import model.data.action.Effect;
import model.data.monster.Monster;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses pre-checked lists of strings into a Model object.
 * takes two lists of strings, one for actions and one for monsters, and parses them into a Model object.
 * @author uepiy
 */

public final class ConfigParser {
    private static final String  SEPARATOR = " ";
    private static final String MONSTER_ACTION_NAME = "[a-zA-Z0-9]+";
    private static final String ACTION_SECTION_START = "action";
    private static final String ACTION_SECTION_END = "end action";
    private static final String EFFECT_DAMAGE = "damage";
    private static final String EFFECT_STATUS_CONDITION = "inflictStatusCondition";
    private static final String EFFECT_STATUS_CHANGE = "inflictStatChange";
    private static final String STRENGTH = "(base [0-9]+|rel 1?[0-9]{1,2}|abs [0-9]+)";

    private static final String COUNT = "([0-9]+|random [0-9]+ [0-9]+)";
    private static final String ELEMENT = "(FIRE|WATER|EARTH|NORMAL)"; //TODO: better descriptor needed
    private static final String STATUS_CONDITION = "(WET|BURN|SLEEP|QUICKSAND)";
    private static final String STAT = "(ATK|DEF|SPD|PRC|AGL)"; //TODO: better descriptor needed
    private static final String PROTECT_TARGET = "(health|stats)";
    private static final String TARGET_MONSTER = "(user|target)";

    private static final String MONSTER_SECTION_START = "monster";

    private ConfigParser() {
    }
    private static List<List<String>> createSublist(List<String> actionLines, String start, String end) {
        List<List<String>> actionLinesList = new ArrayList<>();
        int i = 0;
        while (!actionLines.isEmpty()) {
            if (actionLines.get(0).isBlank()) {
                actionLines.remove(0);
                continue;
            }
            if (actionLines.get(0).matches(start)) {
                actionLinesList.add(new ArrayList<>());
                actionLines.remove(0);
                continue;
            }
            if (actionLines.get(0).matches(end)) {
                actionLines.remove(0);
                i++;
                continue;
            }
            actionLinesList.get(i).add(actionLines.get(0));
            actionLines.remove(0);
        }
        return actionLinesList;
    }
    private static String[] getActionHead(String actionLine) {
        String[] actionHead = actionLine.split(SEPARATOR);
        return new String[]{actionHead[0], actionHead[1]};
    }
    private static List<Action> createActions(List<List<String>> actionLinesList) {
        List<Action> actions = new ArrayList<>();
        //TODO: parse action
        for (List<String> actionLines : actionLinesList) {
            String[] actionHead = getActionHead(actionLines.get(0));
            Effect effect = new Effect(getEffect(actionLines.get(1)));
            actions.add(new Action(actionHead[0], effect));
        }
        return actions;
    }
    private static List<Action> parseActions(List<String> actionLines) {
        List<List<String>> actionLinesList = createSublist(actionLines, ACTION_SECTION_START, ACTION_SECTION_END);

        return createActions(actionLinesList);
    }
    public static Model parseConfig(List<List<String>> actionLines, List<String> monsterLines) {

        List<Action> actions = createActions(actionLines);
        List<Monster> monsters = parseMonsters(monsterLines);

        return new Model(monsters, actions);
    }
}
