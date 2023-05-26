package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.stationary.FakeChest;
import game.grounds.SiteOfLostGrace;
import game.items.runes.GoldenRunes;

import java.io.IOException;

/**
 * Stormveil Castle map class
 *
 * @author William Bata-Kindermann
 * @see SmartGameMap
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
        FakeChest chest1 = new FakeChest();
        chest1.addItemToInventory(new GoldenRunes());
        this.at(6,11).addActor(chest1);
    }

    @Override
    public void spawnGroundItems() {
        this.at(73,19).addItem(new GoldenRunes());
        this.at(74,1).addItem(new GoldenRunes());
        this.at(22,9).addItem(new GoldenRunes());
    }

    @Override
    public void spawnGroundTiles() {
        this.at(29,21).setGround(new SiteOfLostGrace("Stormveil Main Gate"));
    }

    @Override
    public String toString() {
        return "Stormveil Castle";
    }
}
