package game.world;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.grounds.doors.OneWayGoldenFogDoor;
import game.grounds.doors.TwoWayGoldenFogDoor;
import game.world.maps.BossRoomMap;
import game.world.maps.LimgraveMap;
import game.world.maps.RoundtableHoldMap;
import game.world.maps.StormveilCastleMap;

import java.io.IOException;

/**
 * Class for constructing the game world and linking all the maps together
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see game.world.maps.SmartGameMap
 * @see TwoWayGoldenFogDoor
 * @see OneWayGoldenFogDoor
 */
public class WorldConstructor {

    /**
     * Generates all GameMaps and places the starting elements.
     *
     * @param world the world to generate the maps for
     * @param player the player character
     */
    public static void generateMaps(World world, Player player) {

        // Initialize all the map variables
        GameMap limgrave;
        GameMap bossRoom;
        GameMap roundTableHold;
        GameMap stormveilCastle;

        // Attempt to create all the maps
        try {
            limgrave = new LimgraveMap(world);
            bossRoom = new BossRoomMap(world);
            roundTableHold = new RoundtableHoldMap(world);
            stormveilCastle = new StormveilCastleMap(world);
        } catch (IOException e) {
            // If the map file fails to load
            e.printStackTrace();
            throw new IllegalStateException("Map/s failed to load");
        }

        // Create doorways
        createDoorway(limgrave.at(0, 22), roundTableHold.at(9, 10));
        createDoorway(limgrave.at(29, 0), stormveilCastle.at(38, 23));

        createOneWayDoorway(stormveilCastle.at(0,1), bossRoom.at(24,3));

        // Add the player to the map
        world.addPlayer(player, limgrave.at(37, 11));

    }

    /**
     * Creates a two-way doorway between 2 in-game locations
     * @param location1 The first location
     * @param location2 The second location
     */
    public static void createDoorway(Location location1, Location location2) {
        // Create and place doors
        TwoWayGoldenFogDoor door1 = new TwoWayGoldenFogDoor();
        door1.placeDoor(location1);
        TwoWayGoldenFogDoor door2 = new TwoWayGoldenFogDoor();
        door2.placeDoor(location2);

        // Link the doors
        door1.setOtherDoor(door2, location2.map().toString());
        door2.setOtherDoor(door1, location1.map().toString());
    }

    /**
     * Creates a one-way doorway between 2 in-game locations
     * @param fromLocation Location of door
     * @param toLocation Location of exit
     */
    public static void createOneWayDoorway(Location fromLocation, Location toLocation) {
        // Create and place door
        OneWayGoldenFogDoor door = new OneWayGoldenFogDoor();
        door.placeDoor(fromLocation);

        // Mark the location of the output of door
        door.setDestination(toLocation, toLocation.map().toString());
    }
}
