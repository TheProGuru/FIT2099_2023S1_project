package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.DeathAction;

public class Cliff extends Ground {

    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public void tick(Location location) {
        if (location.getActor() != null) {
            new DeathAction(location.getActor()).execute(location.getActor(), location.map());
        }
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return (actor.hasCapability(Status.IS_PLAYER));
    }
}
