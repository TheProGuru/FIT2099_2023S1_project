package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;
import game.grounds.spawnableGrounds.SiteOfLostGrace;
import game.reset.ResetManager;

import java.io.IOException;

public class LimgraveMap extends SelfConstructingMap {


    public LimgraveMap(World world) throws IOException {
        super(world, "src/game/world/mapFiles/Limgrave.txt");
    }

    @Override
    public void spawnActors() {
            this.at(37,10).addActor(new MerchantKale());
    }

    @Override
    public void spawnGroundItems() {

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
