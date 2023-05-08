package game.world.maps;

import edu.monash.fit2099.engine.positions.World;

import java.io.IOException;

public class RoundTableHoldMap extends SelfConstructingMap {
    public RoundTableHoldMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/RoundtableHold.txt");
    }

    @Override
    public void spawnActors() {

    }

    @Override
    public void spawnGroundItems() {

    }
}
