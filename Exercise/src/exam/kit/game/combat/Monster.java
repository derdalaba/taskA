package exam.kit.game.combat;

import exam.kit.exceptions.InvalidArgumentException;
import exam.kit.game.BaseState;
import exam.kit.game.MonsterTemplate;
import exam.kit.game.action.Action;

/**
 * Represents a monster in the game.
 * This is monster in combat.
 * @author uepiy
 */

public class Monster {
    private MonsterTemplate monster;
    private BaseState baseState;
    private Status status;
    /**
     * Constructs a Monster object from the template.
     * @param template the monster template
     */
    public Monster(MonsterTemplate template) {
        this.monster = template;
        this.baseState = template.baseState();
        this.status = new Status(baseState);
    }
    /**
     * Gets the monster template.
     * @return the monster template
     */
    public MonsterTemplate getMonsterTemplate() {
        return monster;
    }
    /**
     * Gets the action with the specified name.
     * @param actionName the name of the action
     * @return the action with the specified name
     * @throws InvalidArgumentException if the action is not found
     */
    public Action getAction(String actionName) throws InvalidArgumentException {
        for (Action action : monster.actionList()) {
            if (action.name().equals(actionName)) {
                return action;
            }
        }
        throw new InvalidArgumentException("Action not found: " + actionName);
    }
    /**
     * Gets the status of the monster.
     * @return the status of the monster
     */
    public Status getStatus() {
        return status;
    }
}
