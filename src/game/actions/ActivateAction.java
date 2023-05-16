package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.Activatable;

/**
 * Action to activate an Activatable
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Activatable
 */
public class ActivateAction extends Action {

    /**
     * Instance to activate
     */
    Activatable toActivate;

    /**
     * Constructor
     * @param toActivate Instance to activate
     */
    public ActivateAction(Activatable toActivate) {
        this.toActivate = toActivate;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return toActivate.activate();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " activates " + toActivate;
    }
}
