package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;

public class Graveyard extends SpawnableGround {

    public Graveyard() {
        super('n', 27);
    }

    @Override
    protected Actor spawn() {
        return null;
    }
}
