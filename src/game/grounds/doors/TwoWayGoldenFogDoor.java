package game.grounds.doors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 * Two-way Golden Fog door class
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 * @see Door
 * @see TeleportAction
 */
public class TwoWayGoldenFogDoor extends Door {

    /**
     * The door that this instance is linked with
     */
    private Door otherDoor;

    /**
     * Constructor.
     */
    public TwoWayGoldenFogDoor() {
        super('D');
    }

    /**
     * Sets the other side of the doorway
     * @param door Door on the other side
     * @param destinationString Description of output area
     */
    public void setOtherDoor(Door door, String destinationString) {
        this.otherDoor = door;
        this.setDestinationString(destinationString);
    }

    /**
     * Gets the allowable actions for the Two-way Golden Fog Door
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al = new ActionList();
        al.add(new TeleportAction(otherDoor.getLocation(), this.getDestinationString()));
        return al;
    }
}
