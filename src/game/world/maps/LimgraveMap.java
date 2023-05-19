package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;
import game.grounds.SiteOfLostGrace;
import game.items.runes.GoldenRunes;
import game.reset.ResetManager;

import java.io.IOException;

/**
 * Limgrave map class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SmartGameMap
 *
 */
public class LimgraveMap extends SmartGameMap {

    /**
     * Constructor. Places itself in the world automatically
     *
     * @param world The world that it is a part of.
     * @throws IOException When the file cannot be found/read
     */
    public LimgraveMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/Limgrave.txt");
    }


    @Override
    public void spawnActors() {
            this.at(37,10).addActor(new MerchantKale());
    }

    @Override
    public void spawnGroundItems() {

        this.at(30,10).addItem(new GoldenRunes());
    }

    @Override
    public void spawnGroundTiles() {

        // Sets the location of "The First Step" and also registers it as the starting location
        this.at(41,10).setGround(new SiteOfLostGrace("The First Step"));
        ResetManager.getInstance().setLastRest(this.at(41,10));
    }

    @Override
    public String toString() {
        return "Limgrave";
    }
}
