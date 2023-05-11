package game.world.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;

import java.io.IOException;


public abstract class SelfConstructingMap extends GameMap {

    private static final FancyGroundFactory fancyGroundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new Graveyard(), new PuddleOfWater(), new Cliff());

    protected SelfConstructingMap(World world, String mapFilePath) throws IOException {
        super(getFancyGroundFactory(), mapFilePath);
        world.addGameMap(this);
        spawnActors();
        spawnGroundItems();
        spawnGroundTiles();
    }

    public abstract void spawnActors();

    public abstract void spawnGroundItems();

    public abstract void spawnGroundTiles();

    public static FancyGroundFactory getFancyGroundFactory() {
        return fancyGroundFactory;
    }

}
