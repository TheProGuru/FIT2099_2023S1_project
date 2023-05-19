package game.world.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;
import game.grounds.spawnableGrounds.*;

import java.io.IOException;

/**
 * Smart/Self-Constructing GameMap class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see GameMap
 * @see FancyGroundFactory
 * @see edu.monash.fit2099.engine.positions.Ground
 *
 */
public abstract class SmartGameMap extends GameMap {

    /**
     * Adds all stateless ground classes to a global factory
     */
    private static final FancyGroundFactory fancyGroundFactory = new FancyGroundFactory(
            new Dirt(),
            new Wall(),
            new Floor(),
            new GustOfWind(),
            new Graveyard(),
            new PuddleOfWater(),
            new Cage(),
            new Barrack(),
            new Cliff(),
            new SummonSign()
    );

    /**
     * Constructor. Places itself in the world automatically
     *
     * @param world The world that it is a part of.
     * @param mapFilePath Relative filepath of the Map to load
     * @throws IOException When the file cannot be found/read
     */
    protected SmartGameMap(World world, String mapFilePath) throws IOException {
        super(getFancyGroundFactory(), mapFilePath);
        // Adds itself to the world
        world.addGameMap(this);

        // Spawns all relevant actors
        spawnActors();
        spawnGroundItems();
        spawnGroundTiles();
    }

    /**
     * Spawns all starting actors to GameMap
     */
    public abstract void spawnActors();

    /**
     * Spawns all starting Items to GameMap
     */
    public abstract void spawnGroundItems();

    /**
     * Spawns all starting stateful ground tiles to GameMap
     */
    public abstract void spawnGroundTiles();

    /**
     * Returns the global FancyGroundFactory
     * @return FancyGroundFactory
     */
    public static FancyGroundFactory getFancyGroundFactory() {
        return fancyGroundFactory;
    }

    /**
     * Returns the name of the SmartGameMap
     * @return name of the SmartGameMap
     */
    public abstract String toString();

}
