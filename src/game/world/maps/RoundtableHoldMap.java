package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.grounds.SiteOfLostGrace;

import java.io.IOException;

/**
 * Roundtable Hold map class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SmartGameMap
 *
 */
public class RoundtableHoldMap extends SmartGameMap {

    /**
     * Constructor. Places itself in the world automatically
     *
     * @param world The world that it is a part of.
     * @throws IOException When the file cannot be found/read
     */
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
        this.at(2,8).setGround(new SiteOfLostGrace("Table of Lost Grace"));
    }

    @Override
    public String toString() {
        return "Roundtable Hold";
    }
}
