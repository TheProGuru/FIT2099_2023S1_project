package game.world.maps;

import edu.monash.fit2099.engine.positions.World;

import java.io.IOException;

public class RoundtableHoldMap extends SmartGameMap {
    public RoundtableHoldMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/RoundtableHold.txt");
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
        return "Roundtable Hold";
    }
}
