package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An action that replaces one actor with another
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 *
 * used by doing: new ReplaceAction(<Actor that it will become>).execute(<actor that will go away>, map)
 */

public class ReplaceAction extends Action {

    private Actor replacement;

    public ReplaceAction(Actor replacement) {
        this.replacement = replacement;
    }

    /**
     * The target is
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        // store location of the actor
        Location locationOfTarget = map.locationOf(target);
        // remove actor
        map.removeActor(target);

        //add the new actor in its place
        map.addActor(this.replacement, locationOfTarget);

        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " became " + this.replacement;
    }
}
