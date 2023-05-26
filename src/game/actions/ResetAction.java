package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;

/**
 * Action to Reset Game
 *
 * @author William Bata-Kindermann
 * @see Action
 * @see ResetManager
 */
public class ResetAction extends Action {

    /**
     * Executes the Game Reset
     * @param player The actor performing the action.
     * @param map The map the actor is on.
     * @return Flavour text of the reset
     */
    @Override
    public String execute(Actor player, GameMap map) {
        ResetManager.getInstance().runReset(map);
        return "Everything fades to black";
    }

    /**
     * Describes the action on the menu
     * @param actor The actor performing the action.
     * @return A description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game (Dev Feature)";
    }
}
