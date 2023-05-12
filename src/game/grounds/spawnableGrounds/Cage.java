package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.Dog;
import game.actors.enemies.PileOfBones;

public class Cage extends SpawnableGround{

    public Cage() {
        super('<', 37);
    }
    @Override
    protected Actor spawn() {
        return new Dog();
    }
}
