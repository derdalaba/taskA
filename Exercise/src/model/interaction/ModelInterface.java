package model.interaction;

import model.data.CombatState;


/**
 * This class acts as an interface to the controller and the view.
 * It abstracts the model's state and provides a way for the controller to interact with it.
 * @author uepiy
 */

public class ModelInterface {
    private CombatState combatState;

    public ModelInterface(CombatState combatState) {
        this.combatState = combatState;
    }
}
