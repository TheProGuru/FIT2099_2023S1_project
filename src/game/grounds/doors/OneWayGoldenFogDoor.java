package game.grounds.doors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

public class OneWayGoldenFogDoor extends Door{

    private Location destinationLocation;
    /**
     * Constructor.
     */
    public OneWayGoldenFogDoor() {
        super('D');
    }

    public void setDestination(Location location, String destinationString) {
        this.destinationLocation = location;
        this.setDestinationString(destinationString);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al = new ActionList();
        al.add(new TeleportAction(destinationLocation, this.getDestinationString()));
        return al;
    }
}
