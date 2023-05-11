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

public class WorldConstructor {

    public static void generateMaps(World world, Player player) {

        GameMap limgrave = null;
        GameMap bossRoom = null;
        GameMap roundTableHold = null;
        GameMap stormveilCastle = null;
        try {
            limgrave = new LimgraveMap(world);
            bossRoom = new BossRoomMap(world);
            roundTableHold = new RoundtableHoldMap(world);
            stormveilCastle = new StormveilCastleMap(world);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Map/s failed to load");
        }


        createDoorway(limgrave, limgrave.at(29, 0), roundTableHold, roundTableHold.at(9, 10));
        createDoorway(limgrave, limgrave.at(0, 22), stormveilCastle, stormveilCastle.at(74, 22));

        createOneWayDoorway(stormveilCastle, stormveilCastle.at(0,2), bossRoom, bossRoom.at(24,3));


        world.addPlayer(player, limgrave.at(37, 11));

    }

    public static void createDoorway(GameMap map1, Location location1, GameMap map2, Location location2) {
        TwoWayGoldenFogDoor door1 = new TwoWayGoldenFogDoor();
        door1.placeDoor(map1, location1);
        TwoWayGoldenFogDoor door2 = new TwoWayGoldenFogDoor();
        door2.placeDoor(map2, location2);

        door1.setOtherDoor(door2, map2.toString());
        door2.setOtherDoor(door1, map1.toString());
    }

    public static void createOneWayDoorway(GameMap from, Location fromLocation, GameMap to, Location toLocation) {
        OneWayGoldenFogDoor door = new OneWayGoldenFogDoor();
        door.placeDoor(from, fromLocation);
        door.setDestination(to, toLocation, "The Demigod's Chambers");


    }
}
