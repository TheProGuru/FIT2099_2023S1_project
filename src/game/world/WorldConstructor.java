package game.world;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.grounds.GoldenFogDoor;
import game.world.maps.BossRoomMap;
import game.world.maps.LimgraveMap;
import game.world.maps.RoundTableHoldMap;
import game.world.maps.StormveilCastleMap;

import java.io.IOException;

public class WorldConstructor {

    public static void generateMaps(World world, Player player) {

        GameMap limgrave = null;
        GameMap bossRoom = null;
        GameMap roundTableHold = null;
        GameMap storveilCastle = null;
        try {
            limgrave = new LimgraveMap(world);
            bossRoom = new BossRoomMap(world);
            roundTableHold = new RoundTableHoldMap(world);
            storveilCastle = new StormveilCastleMap(world);
        } catch (IOException e) {
            e.printStackTrace();
        }



        GoldenFogDoor door1 = new GoldenFogDoor();
        door1.placeDoor(limgrave, 38,13);
        GoldenFogDoor door2 = new GoldenFogDoor();
        door2.placeDoor(bossRoom, 5,5);

        door1.setOtherDoor(door2, "Boss Room");
        door2.setOtherDoor(door1, "Limgrave");

        world.addPlayer(player, limgrave.at(37, 11));

    }
}
