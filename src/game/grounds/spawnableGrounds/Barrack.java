package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.GodrickSoldier;

/**
 * Spawnable Ground/Spawner for GodrickSoldier
 * Display Character: B
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see SpawnableGround
 * @see GodrickSoldier
 */
public class Barrack extends SpawnableGround {

    /**
     * Constructor
     */
    public Barrack() {
        super('B', 45);
    }

    @Override
    protected Actor spawn() {
        return new GodrickSoldier();
    }
}
