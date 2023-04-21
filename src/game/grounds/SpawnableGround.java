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
    public SpawnableGround(char displayChar, int chanceToSpawn) {
        super(displayChar);
        if (!(chanceToSpawn <= 1.0 & chanceToSpawn >= 0.0)) {
            throw new IllegalArgumentException("chanceToSpawn isn't within range");
        }
        this.chanceToSpawn = chanceToSpawn;
    }

    @Override
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(100) < this.chanceToSpawn) {
            Actor toSpawn = spawn();

            List<Location> adjacentLocations = LocationHelper.getAdjacentLocationsActorEnter(location, toSpawn);
            Location locationToSpawn = adjacentLocations.get(RandomNumberGenerator.getRandomInt(adjacentLocations.size()));

            locationToSpawn.addActor(toSpawn);
        }
    }

    public abstract Actor spawn();
}
