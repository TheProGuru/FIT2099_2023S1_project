package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;


/**
 * Abstraction of a general Spawnable/Spawner ground class.
 *
 * @author William Bata-Kindermann
 * @see Actor
 * @see Ground
 */
public abstract class SpawnableGround extends Ground {

    /**
     * Chance to spawn an Actor as a percentage
     * 0 <= chance <= 100
     */
    private final int chanceToSpawn;

    /**
     * Constructor
     * @param displayChar character to display for this type of terrain
     * @param chanceToSpawn Chance to spawn an Actor as a percentage, must be in range 0-100 (inclusive)
     */
    protected SpawnableGround(char displayChar, int chanceToSpawn) {
        super(displayChar);
        if (!(chanceToSpawn <= 100 & chanceToSpawn >= 0)) {
            throw new IllegalArgumentException("chanceToSpawn isn't within range");
        }
        this.chanceToSpawn = chanceToSpawn;
    }

    /**
     * Game tick call. Checks to see if the tile can spawn an Actor and spawns if able.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) < this.chanceToSpawn) {
            Actor toSpawn = spawn();
            if (location.canActorEnter(toSpawn)) { // If the actor can move into/can go to tile
                location.addActor(toSpawn);
            }
        }
    }

    /**
     * Creates an instance of the Actor to spawn
     * @return Actor to spawn
     */
    protected abstract Actor spawn();
}
