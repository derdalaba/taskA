package exam.kit.util.system;

import exam.kit.exceptions.MalformedConfigException;
import exam.kit.game.action.Action;
import exam.kit.game.Element;
import exam.kit.game.action.effect.Effect;

import java.util.List;

/**
 * Parses actions from a list of lines.
 * @author uepiy
 */

public final class ActionParser {
    private static final String ACTION_SECTION_START_REGEX = "action ";
    private static final String MALFORMED_ACTION_EXCEPTION_MESSAGE = "Malformed action section";
    private ActionParser() {
    }
    /**
     * Parses one action from the list of strings.
     * @param actionSection list of strings containing the action lines
     * @return Action object created from the data
     * @throws MalformedConfigException if the lines are not formatted correctly
     */
    public static Action parseAction(List<String> actionSection) throws MalformedConfigException {
        System.out.println(actionSection.get(0) + "hi");
        String[] actionHeader = getActionHeader(actionSection.get(0));
        List<Effect> effectList = EffectParser.parseEffects(actionSection.subList(1, actionSection.size() - 1));
        return new Action(actionHeader[0], Element.valueOf(actionHeader[1]), effectList);
    }
    private static String[] getActionHeader(String actionHeaderLine) throws MalformedConfigException {
        String header = actionHeaderLine.substring(ACTION_SECTION_START_REGEX.length());
        String[] headParts = header.split(" ");
        if (headParts.length != 2) {
            throw new MalformedConfigException(MALFORMED_ACTION_EXCEPTION_MESSAGE);
        }
        if (!Element.contains(headParts[1])) {
            throw new MalformedConfigException(MALFORMED_ACTION_EXCEPTION_MESSAGE);
        }
        return headParts;
    }
}
