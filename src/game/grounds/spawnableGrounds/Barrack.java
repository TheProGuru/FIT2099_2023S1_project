package game.grounds.spawnableGrounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.enemies.PileOfBones;

public class Barrack extends SpawnableGround {

    public Barrack() {
        super('B', 45);
    }
    @Override
    protected Actor spawn() {
        return new PileOfBones();
    }
}
