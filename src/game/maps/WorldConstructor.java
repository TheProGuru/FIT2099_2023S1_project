package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.ArchetypePicker;
import game.actors.Player;
import game.actors.archetypes.Archetype;
import game.grounds.GoldenFogDoor;

import java.util.ArrayList;
import java.util.HashMap;

public class WorldConstructor {

    public void testDoor(World world) {
        GameMap limgrave = new LimgraveMapConstructor().generateMap(world);
        GameMap bossRoom = new BossRoomMapConstructor().generateMap(world);


        GoldenFogDoor door1 = new GoldenFogDoor();
        door1.placeDoor(limgrave, 37,10);
        GoldenFogDoor door2 = new GoldenFogDoor();
        door2.placeDoor(bossRoom, 5,5);

        door1.setOtherDoor(door2, "Boss Room");
        door2.setOtherDoor(door1, "Limgrave");

        Archetype playerArchetype = ArchetypePicker.getArchetypeChoice();
        Player player = new Player("Tarnished", '@', playerArchetype);

        world.addPlayer(player, limgrave.at(37, 11));

    }
}
