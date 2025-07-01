package exam.kit.game.action;

import exam.kit.game.Element;
import exam.kit.game.action.effect.Effect;

import java.util.List;

/**
 * Represents an action that can be performed by a monster in combat.
 * @param name name of the action
 * @param element element of the action
 * @param effectList list of effects the action has
 * @author uepiy
 */

public record Action(String name, Element element, List<Effect> effectList) {

}
