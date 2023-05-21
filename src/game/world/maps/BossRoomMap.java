package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.enemies.GodrickTheGrafted;

import java.io.IOException;

/**
 * Boss Room map class
 * <p>
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
//        Chest bossChest = new Chest();
//        bossChest.addItemToInventory(new RemembranceOfTheGrafted());
//        this.at(18,4).addActor(bossChest);

        this.at(10,4).addActor(new GodrickTheGrafted());
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
