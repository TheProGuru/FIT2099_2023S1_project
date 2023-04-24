package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.LoneWolf;

public class GustOfWind extends SpawnableGround {

    public GustOfWind() {
        super('&', 33);
    }

    @Override
    public Actor spawn() {
        return new LoneWolf();
    }
}


