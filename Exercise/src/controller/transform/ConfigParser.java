package controller.transform;

import model.Model;
import model.data.Action;
import model.data.Monster;

import java.util.ArrayList;
import java.util.List;

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
    private static String getFirstWord(String line) {
        return line.trim().split(SEPARATOR)[0];
    }

    private static List<String> getActionLines(List<String> config) {
        List<String> actionLines = new ArrayList<>();
        int i = 0;
        while (i < config.size() && !getFirstWord(config.get(i)).startsWith(MONSTER_SECTION_START)) {
            actionLines.add(config.get(i));
            i++;
        }
        return actionLines;
    }
    private static List<String> getMonsterLines(List<String> config) {
        int i = 0;
        while (i < config.size() && !getFirstWord(config.get(i)).startsWith(MONSTER_SECTION_START)) {
            i++;
        }
        return config.subList(i, config.size());
    }
    private static List<Action> parseActions(List<String> actionLines) {
        List<Action> actions = new ArrayList<>();
        List<List<String>> actionLinesList = new ArrayList<>();
        while (!actionLines.isEmpty()) {
            if (actionLines.get(0).isBlank()) {
                actionLines.remove(0);
                continue;
            }
            //TODO: split action lines into separate lists. Create a new Action from each list.
        }

        return actions;
    }
    public static Model parseConfig(List<String> config) {
        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }

        List<Action> actions = parseActions(getActionLines(config));
        List<Monster> monsters = parseMonsters(getMonsterLines(config));

        return new Model(monsters, actions);
    }
}
