package model.interaction;

import model.Model;
import model.data.CombatState;
import views.terminal.exceptions.MonstersNotFoundException;

import java.util.List;


/**
 * This class acts as an interface to the controller and the view.
 * It abstracts the model's state and provides a way for the controller to interact with it.
 * @author uepiy
 */

public class ModelInterface {
    private Model model;

    public ModelInterface(Model model) {
        this.model = model;
    }
    public void replaceModel(Model model) {
        this.model = model;
    }
    public int startCompetition(List<String> monsterNames) throws MonstersNotFoundException {
        model.startCompetition(monsterNames);
        return monsterNames.size();
    }
}
