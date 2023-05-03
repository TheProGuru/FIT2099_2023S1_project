package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetManager;

/**
 * Action to rest
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Action
 * @see ResetManager
 */
public class RestAction extends Action {
    /**
     * The location the actor rested at
     */
    private Location location;

    /**
     * Constructor
     * @param location Location of rest
     */
    public RestAction(Location location) {
        super();
        this.location = location;
    }

    /**
     * Executes the rest
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Description of outcome
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager RM = ResetManager.getInstance();
        RM.setLastRest(map.locationOf(actor));
        RM.runRest(map);
        return actor + " rests at " + location.getGround().toString();
    }

    /**
     * Description of what could happen
     * @param actor The actor performing the action.
     * @return A description of resting
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests";
    }

}
