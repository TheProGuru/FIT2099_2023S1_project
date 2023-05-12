package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends Action {


    Location teleportLocation;
    String locationName;

    public TeleportAction(Location location, String locationName) {
        this.teleportLocation = location;
        this.locationName = locationName;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        teleportLocation.map().addActor(actor, teleportLocation);
        return actor + " went to " + locationName;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " went to " + locationName;
    }
}
