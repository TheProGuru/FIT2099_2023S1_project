package game.world.maps;

import edu.monash.fit2099.engine.positions.World;

import java.io.IOException;

public class BossRoomMap extends SmartGameMap {
    public BossRoomMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/BossRoom.txt");
    }

    @Override
    public void spawnActors() {

    }

    @Override
    public void spawnGroundItems() {

    }

    @Override
    public void spawnGroundTiles() {

    }

    @Override
    public String toString() {
        return "Boss Room";
    }
}
