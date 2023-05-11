package game.world.maps;

import edu.monash.fit2099.engine.positions.World;

import java.io.IOException;

public class StormveilCastleMap extends SelfConstructingMap {
    public StormveilCastleMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/StormveilCastle.txt");
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
        return "Stormveil Castle";
    }
}
