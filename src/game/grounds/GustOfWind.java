package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.LoneWolf;

/**
 * Spawnable Ground/Spawner for LoneWolf
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 * 
 * @see SpawnableGround
 * @see LoneWolf
 */
public class GustOfWind extends SpawnableGround {

    /**
     * Constructor
     */
    public GustOfWind() {
        super('&', 33);
    }

    /**
     * Creates an instance of LoneWolf
     * @return Newly created instance of LoneWolf
     */
    @Override
    protected Actor spawn() {
        return new LoneWolf();
    }
}


