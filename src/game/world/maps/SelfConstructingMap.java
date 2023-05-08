package game.world.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;

import java.io.IOException;


public abstract class SelfConstructingMap extends GameMap {

    private static final FancyGroundFactory fancyGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new Graveyard(), new PuddleOfWater(), new SiteOfLostGrace());

    protected SelfConstructingMap(World world, String mapFilePath) throws IOException {
        super(getFancyGroundFactory(), mapFilePath);
        world.addGameMap(this);
        spawnActors();
        spawnGroundItems();
    }

    public abstract void spawnActors();

    public abstract void spawnGroundItems();

    public static FancyGroundFactory getFancyGroundFactory() {
        return fancyGroundFactory;
    };

}
