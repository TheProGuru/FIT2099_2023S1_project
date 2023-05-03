package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction; // Remove this later
import game.actions.RestAction;
import game.items.FlaskOfCrimsonTears; // Remove this later


/**
 * Site of Lost Grace
 * Allows the player to rest
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 */
public class SiteOfLostGrace extends Ground {

    private String name = "Site of Lost Grace";
    private static boolean firstRest = true;

    /**
     * Constructor
     */
    public SiteOfLostGrace() {
        super('U');
    }

    /**
     * Gets the allowable actions for the Site Of Lost Grace
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al =  new ActionList();
        al.add(new RestAction(location));
        return al;
    }

    /**
     * Gets the name of the instance
     * @return Name as String
     */
    @Override
    public String toString() {
        if (firstRest) {
            firstRest = false;
            this.name = "The First Step";
        }
        return name;
    }
}
