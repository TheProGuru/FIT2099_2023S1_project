package game.world.maps;

import edu.monash.fit2099.engine.positions.World;

import java.io.IOException;

/**
 * Stormveil Castle map class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SmartGameMap
 *
 */
public class StormveilCastleMap extends SmartGameMap {

    /**
     * Constructor. Places itself in the world automatically
     *
     * @param world The world that it is a part of.
     * @throws IOException When the file cannot be found/read
     */
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
