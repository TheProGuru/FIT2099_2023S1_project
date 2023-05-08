package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.*;

public abstract class MapConstructor {

    private static final FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new Graveyard(), new PuddleOfWater(), new SiteOfLostGrace());

    public static FancyGroundFactory getFancyGroundFactory() {
        return groundFactory;
    }

    public abstract GameMap generateMap(World world);

    public abstract void spawnActors(GameMap map);

    public abstract void spawnGroundItems(GameMap map);
}
