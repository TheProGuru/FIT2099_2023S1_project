package game.world.maps;

import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;

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
}
