package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationHelper {

    public static List<Location> getAdjacentLocations(Location location) {
        List<Location> locations = new ArrayList<Location>();
        List<Exit> exits = location.getExits();
        for (Exit exit : exits) {
            locations.add(exit.getDestination());
        }
        return locations;
    }

    public static List<Location> getAdjacentLocationsActorEnter(Location location, Actor actor) {
        List<Location> locations = new ArrayList<Location>();
        List<Exit> exits = location.getExits();
        for (Exit exit : exits) {
            if (!(exit.getDestination().canActorEnter(actor))) {
                locations.add(exit.getDestination());
            }
        }
        return locations;

    }
}
