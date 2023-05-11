package game.grounds.doors;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Door extends Ground {

    private GameMap map;
    private Location location;
    private String destinationString;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Door(char displayChar) {
        super(displayChar);
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

    public String getDestinationString() {
        return this.destinationString;
    }

    public void setDestinationString(String destinationString) {
        this.destinationString = destinationString;
    }
}
