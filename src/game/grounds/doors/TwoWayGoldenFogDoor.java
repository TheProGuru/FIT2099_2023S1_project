package game.grounds.doors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 *
 */
public class TwoWayGoldenFogDoor extends Door {

    private TwoWayGoldenFogDoor otherDoor;

    /**
     * Constructor.
     */
    public TwoWayGoldenFogDoor() {
        super('D');
    }

    public void setOtherDoor(TwoWayGoldenFogDoor door, String destinationString) {
        this.otherDoor = door;
        this.setDestinationString(destinationString);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al = new ActionList();
        al.add(new TeleportAction(otherDoor.getLocation(), this.getDestinationString()));
        return al;
    }
}
