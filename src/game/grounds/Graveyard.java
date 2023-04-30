package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.HeavySkeletalSwordsman;


/**
 * Spawnable Ground/Spawner for HeavySkeletalSwordsman
 * Display Character: n
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SpawnableGround
 * @see HeavySkeletalSwordsman
 */
public class Graveyard extends SpawnableGround {

    /**
     * Constructor
     */
    public Graveyard() {
        super('n', 27);
    }

    /**
     * Creates an instance of HeavySkeletalSwordsman
     * @return Newly created instance of HeavySkeletalSwordsman
     */
    @Override
    protected Actor spawn() {
        return new HeavySkeletalSwordsman();
    }
}
