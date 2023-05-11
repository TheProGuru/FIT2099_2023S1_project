package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 *
 */
public class GoldenFogDoor extends Ground {

    GameMap map;
    Location location;
    GoldenFogDoor otherDoor;
    String destinationString;

    /**
     * Constructor.
     */
    public GoldenFogDoor() {
        super('D');
    }

    public void setOtherDoor(GoldenFogDoor door, String destinationString) {
        this.otherDoor = door;
        this.destinationString = destinationString;
    }

    public void placeDoor(GameMap map, Location location) {
        this.map = map;
        this.location = location;
        location.setGround(this);
    }

    public GameMap getMap() {
        return this.map;
    }

    public Location getLocation() {
        return this.location;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al = new ActionList();
        al.add(new TeleportAction(otherDoor.getMap(), otherDoor.getLocation(), this.destinationString));
        return al;
    }
}
