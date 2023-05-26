package game.grounds.doors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * One-way Golden Fog door class
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 * @see Door
 */
public class OneWayGoldenFogDoor extends Door{

    /**
     * Output location
     */
    private Location destinationLocation;

    /**
     * Constructor.
     */
    public OneWayGoldenFogDoor() {
        super('D');
    }

    /**
     * Setter for the output destination of the One-Way door
     * @param location Location of output
     * @param destinationString Description of output area
     */
    public void setDestination(Location location, String destinationString) {
        this.destinationLocation = location;
        this.setDestinationString(destinationString);
    }

    /**
     * Gets the allowable actions for the One-way Golden Fog Door
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al = new ActionList();
        al.add(new MoveActorAction(location, "to "+ destinationLocation));
        return al;
    }
}
