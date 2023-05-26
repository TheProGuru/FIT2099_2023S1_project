package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.GiantCrab;

/**
 * Spawnable Ground/Spawner for GiantCrab
 * Display Character: ~
 *
 * @author William Bata-Kindermann
 * @see SpawnableGround
 * @see GiantCrab
 */
public class PuddleOfWater extends SpawnableGround {

    /**
     * Constructor
     */
    public PuddleOfWater() {
        super('~', 2);
    }

    /**
     * Creates an instance of GiantCrab
     * @return Newly created instance of GiantCrab
     */
    @Override
    protected Actor spawn() {
        return new GiantCrab();
    }
}
