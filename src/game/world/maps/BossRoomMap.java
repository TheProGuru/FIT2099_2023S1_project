package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.grounds.SiteOfLostGrace;

import java.io.IOException;

/**
 * Boss Room map class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SmartGameMap
 *
 */
public class BossRoomMap extends SmartGameMap {

    /**
     * Constructor. Places itself in the world automatically
     *
     * @param world The world that it is a part of.
     * @throws IOException When the file cannot be found/read
     */
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
        this.at(1,2).setGround(new SiteOfLostGrace("Godrick the Grafted")); // Until boss functionality
    }

    @Override
    public String toString() {
        return "Boss Room";
    }
}
