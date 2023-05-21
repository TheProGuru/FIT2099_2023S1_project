package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.FingerReaderEnia;
import game.actors.stationary.Chest;
import game.grounds.SiteOfLostGrace;
import game.items.runes.GoldenRunes;

import java.io.IOException;

/**
 * Roundtable Hold map class
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
        this.at(9,4).addActor(new FingerReaderEnia());
    }

    @Override
    public void spawnGroundItems() {
    }

    @Override
    public void spawnGroundTiles() {
        this.at(2,8).setGround(new SiteOfLostGrace("Table of Lost Grace"));

        Chest chest1 = new Chest();
        chest1.addItemToInventory(new GoldenRunes());
        this.at(15,2).addActor(chest1);
    }

    @Override
    public String toString() {
        return "Roundtable Hold";
    }
}
