package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.Dog;

/**
 * Spawnable Ground/Spawner for Dog
 * Display Character: <
 *
 * @author William Bata-Kindermann
 * @see SpawnableGround
 * @see Dog
 */
public class Cage extends SpawnableGround{

    /**
     * Constructor
     */
    public Cage() {
        super('<', 37);
    }
    @Override
    protected Actor spawn() {
        return new Dog();
    }
}
