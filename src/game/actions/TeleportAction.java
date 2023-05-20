package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Action to teleport actor
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Action
 * @see GameMap
 * @see Location
 */
public class TeleportAction extends Action {

    /**
     * Location to teleport the actor
     */
    Location teleportLocation;

    /**
     * Description/Name of the location that the actor will go
     */
    String locationName;

    /**
     * Constructor
     * @param location Location to teleport the actor
     * @param locationName Description/Name of the location that the actor will go
     */
    public TeleportAction(Location location, String locationName) {
        this.teleportLocation = location;
        this.locationName = locationName;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Moves the actor
        map.removeActor(actor);
        teleportLocation.map().addActor(actor, teleportLocation);

        return actor + " went to " + locationName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " went to " + locationName;
    }
}
