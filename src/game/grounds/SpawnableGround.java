package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.LocationHelper;
import game.utils.RandomNumberGenerator;

import java.util.List;

public abstract class SpawnableGround extends Ground {

    int chanceToSpawn;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    protected SpawnableGround(char displayChar, int chanceToSpawn) {
        super(displayChar);
        if (!(chanceToSpawn <= 100 & chanceToSpawn >= 0)) {
            throw new IllegalArgumentException("chanceToSpawn isn't within range");
        }
        this.chanceToSpawn = chanceToSpawn;
    }

    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) < this.chanceToSpawn) {
            Actor toSpawn = spawn();
            if (location.canActorEnter(toSpawn)) { // If the actor can move into/can go to tile
                location.addActor(toSpawn);
            }
        }
    }

    abstract Actor spawn();
}
