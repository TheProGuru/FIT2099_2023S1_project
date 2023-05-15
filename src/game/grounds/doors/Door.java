package game.grounds.doors;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Abstract Door Class.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 */
public class Door extends Ground {

    /**
     * Location of this door
     */
    private Location location;

    /**
     * Description of the area the door leads to
     */
    private String destinationString;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Door(char displayChar) {
        super(displayChar);
    }

    public void placeDoor(Location location) {
        this.location = location;
        location.setGround(this);
    }

    public GameMap getMap() {
        return this.location.map();
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
