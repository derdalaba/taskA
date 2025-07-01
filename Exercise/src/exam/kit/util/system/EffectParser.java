package exam.kit.util.system;

import exam.kit.exceptions.MalformedConfigException;
import exam.kit.exceptions.MalformedEffectException;
import exam.kit.game.action.effect.DamageEffect;
import exam.kit.game.action.effect.Effect;
import exam.kit.game.action.effect.HealEffect;
import exam.kit.game.action.effect.ProtectEffect;
import exam.kit.game.action.effect.StatusChangeEffect;
import exam.kit.game.action.effect.StatusConditionEffect;


import java.util.ArrayList;
import java.util.List;

/**
 * Parses effects from a list of strings.
 * @author uepiy
 */

public final class EffectParser {
    private static final String EFFECT_SECTION_MALFORMED_EXCEPTION_MESSAGE = "Malformed effect section.";
    private static final String SEPARATOR = " ";
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
    private EffectParser() {
    }
    /**
     * Parses a list of strings into a list of effects.
     * @param effectSection list of strings representing effects
     * @return list of effects
     * @throws MalformedConfigException if the effect section is malformed
     */
    public static List<Effect> parseEffects(List<String> effectSection) throws MalformedConfigException {
        if (effectSection.isEmpty()) {
            throw new MalformedConfigException(EFFECT_SECTION_MALFORMED_EXCEPTION_MESSAGE);
        }
        List<Effect> effects = new ArrayList<>();
        while (!effectSection.isEmpty()) {
            if (effectSection.get(0).startsWith(EFFECT_REPEAT)) {
                List<String> repeatEffect = new ArrayList<>();
                do {
                    repeatEffect.add(effectSection.remove(0));
                } while (!effectSection.get(0).startsWith(EFFECT_REPEAT_END));
                effects.add(parseRepeat(repeatEffect));
            } else {
                effects.add(parseEffect(effectSection.remove(0)));
            }
        }
        return effects;
    }
    private static Effect parseRepeat(List<String> repeatEffect) throws MalformedConfigException {

        return null;
    }
    private static Effect parseEffect(String effectSection) throws MalformedConfigException {
        String effectType = effectSection.split(SEPARATOR)[FIRST_ELEMENT];
        String[] parameters = effectSection.replaceFirst(effectType + SEPARATOR, "").split(SEPARATOR);
        try {
            return switch (effectType) {
                case EFFECT_DAMAGE -> new DamageEffect(parameters);
                case EFFECT_STATUS_CONDITION -> new StatusConditionEffect(parameters);
                case EFFECT_STATUS_CHANGE -> new StatusChangeEffect(parameters);
                case EFFECT_PROTECT -> new ProtectEffect(parameters);
                case EFFECT_HEAL -> new HealEffect(parameters);
                default -> throw new MalformedConfigException(EFFECT_SECTION_MALFORMED_EXCEPTION_MESSAGE);
            };
        } catch (MalformedEffectException e) {
            throw new MalformedConfigException(EFFECT_SECTION_MALFORMED_EXCEPTION_MESSAGE);
        }
    }
}
