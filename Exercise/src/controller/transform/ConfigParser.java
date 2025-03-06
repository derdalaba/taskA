package controller.transform;

import model.Model;
import model.data.action.Action;
import model.data.action.effect.*;
import model.data.monster.BaseState;
import model.data.monster.Monster;
import model.data.shared.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parses pre-checked lists of strings into a Model object.
 * takes two lists of strings, one for actions and one for monsters, and parses them into a Model object.
 * @author uepiy
 */

public final class ConfigParser {
    private static final String SEPARATOR = " ";
    private static final String MONSTER_ACTION_NAME = "[a-zA-Z0-9]+";
    private static final String ACTION_SECTION_START = "action";
    private static final String ACTION_SECTION_END = "end action";
    private static final String EFFECT_DAMAGE = "damage";
    private static final String EFFECT_STATUS_CONDITION = "inflictStatusCondition";
    private static final String EFFECT_STATUS_CHANGE = "inflictStatChange";
    private static final String EFFECT_PROTECT = "protectStat";
    private static final String EFFECT_HEAL = "heal";
    private static final String EFFECT_REPEAT = "repeat";
    private static final String EFFECT_REPEAT_END = "end repeat";
    private static final String EFFECT_CONTINUE = "continue";
    private static final String RANDOM_COUNT = "random";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int NAME_POSITION = 1;
    private static final int TYPE_POSITION = 2;

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
    private static List<Action> parseActionSequential(List<String> actionLines) {
        List<Action> actionList = new ArrayList<>();
        int i = 0;
        while (!actionLines.isEmpty()) {
            if (actionLines.get(FIRST_ELEMENT).isBlank()) {
                actionLines.remove(FIRST_ELEMENT);
                continue;
            }
            if (actionLines.get(FIRST_ELEMENT).startsWith(ACTION_SECTION_START)) {
                String head = actionLines.remove(FIRST_ELEMENT);
                List<String> effects = new ArrayList<>();
                while (actionLines.get(FIRST_ELEMENT).startsWith(ACTION_SECTION_END)) {
                    effects.add(actionLines.remove(FIRST_ELEMENT));
                }
                String[] actionHeadParts = head.split(SEPARATOR);
                List<Effect> effectList = parseEffects(effects);
                actionList.add(new Action(actionHeadParts[NAME_POSITION], actionHeadParts[TYPE_POSITION], effectList));
                continue;
            }
            if (actionLines.get(FIRST_ELEMENT).matches(ACTION_SECTION_END)) {
                actionLines.remove(FIRST_ELEMENT);
                i++;
                continue;
            }
            throw new IllegalArgumentException("Invalid action section");
        }
        return actionList;
    }
    private static List<Effect> parseEffects(List<String> effectLines) {
        List<Effect> effects = new ArrayList<>();
        while (!effectLines.isEmpty()) {
            if (!effectLines.get(FIRST_ELEMENT).startsWith(EFFECT_REPEAT)) {
                effects.add(parseEffect(effectLines.remove(FIRST_ELEMENT)));
            } else {
                List<Effect> repeatEffects = new ArrayList<>();
                Count count = parseCount(effectLines.remove(FIRST_ELEMENT));
                while (!effectLines.get(FIRST_ELEMENT).startsWith(EFFECT_REPEAT_END)) {
                    repeatEffects.add(parseEffect(effectLines.remove(FIRST_ELEMENT)));
                }

                effects.add(new RepeatEffect(count, repeatEffects));
            }
        }
        return effects;
    }
    private static Count parseCount(String countLine) {
        String[] countParts = countLine.split(SEPARATOR);
        if (countParts[SECOND_ELEMENT].matches(RANDOM_COUNT)) {
            return new RandomCount(Integer.parseInt(countParts[2]), Integer.parseInt(countParts[3]));
        }
        return  new AbsoluteCount(Integer.parseInt(countParts[FIRST_ELEMENT]));

    }
    private static List<Action> createActions(List<List<String>> actionLinesList) {
        List<Action> actions = new ArrayList<>();
        //TODO: refactor

        for (List<String> actionLines : actionLinesList) {
            List<String> effectLines = actionLines.subList(1, actionLines.size());
            List<Effect> effects = new ArrayList<>();
            for (String effect : effectLines) {
                effects.add(parseEffect(effect));
            }
            String[] actionHeadParts = actionLines.get(FIRST_ELEMENT).split(SEPARATOR);
            actions.add(new Action(actionHeadParts[NAME_POSITION], actionHeadParts[TYPE_POSITION], effects));
        }
        return actions;
    }
    private static Effect parseEffect(String effectLine) {
        List<String> effectParts = new ArrayList<>(Arrays.asList(effectLine.split(SEPARATOR)));
        //TODO: better exception
        return switch (effectParts.get(0)) {
            case EFFECT_DAMAGE -> new DamageEffect(effectParts.subList(1, effectParts.size()));
            case EFFECT_STATUS_CONDITION -> new StatusConditionEffect(effectParts.subList(1, effectParts.size()));
            case EFFECT_STATUS_CHANGE -> new StatusChange(effectParts.subList(1, effectParts.size()));
            case EFFECT_PROTECT -> new ProtectEffect(effectParts.subList(1, effectParts.size()));
            case EFFECT_HEAL -> new HealEffect(effectParts.subList(1, effectParts.size()));
            case EFFECT_CONTINUE -> new ContinueEffect(effectParts.subList(1, effectParts.size()));
            default -> throw new IllegalArgumentException("Invalid effect type"); //TODO: better exception
        };
    }
    private static List<Monster> parseMonsters(List<String> monsterLines, List<Action> actions) {
        List<Monster> monsters = new ArrayList<>();
        for (String monsterLine : monsterLines) {
            if (monsterLine.isBlank()) {
                continue;
            }
            monsterLine = monsterLine.trim();
            monsterLine = monsterLine.replaceFirst("monster ", "");
            String[] monsterParts = monsterLine.split(" ");
            String name = monsterParts[0];
            BaseState baseState = parseBaseState(monsterParts);
            Type type = Type.valueOf(monsterParts[1]);
            List<Action> monsterActions = parseMonsterActions(monsterParts, actions);
            monsters.add(new Monster(name, baseState, type, monsterActions));

        }
    }
    private static List<Action> parseMonsterActions(String[] monsterParts, List<Action> actions) {
        List<Action> monsterActions = new ArrayList<>();
        for (int i = 4; i < monsterParts.length; i++) {
            for (Action action : actions) {
                if (action.toString().equals(monsterParts[i])) {
                    monsterActions.add(action);
                    break;
                }
            }
            monsterActions.add(actions.get(Integer.parseInt(monsterParts[i])));
        }
        return monsterActions;
    }
    private static BaseState parseBaseState(String[] monsterParts) {
        int maxHealth = Integer.parseInt(monsterParts[2]);
        int attack = Integer.parseInt(monsterParts[3]);
        int defense = Integer.parseInt(monsterParts[4]);
        int speed = Integer.parseInt(monsterParts[5]);
        return new BaseState(maxHealth, attack, defense, speed);
    }
    public static Model parseConfig(List<List<String>> actionLines, List<String> monsterLines) {

        List<Action> actions = createActions(actionLines);
        List<Monster> monsters = parseMonsters(monsterLines, actions);

        return new Model(monsters, actions);
    }
}
