package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.combat.DeathAction;

/**
 * Cliff ground tile class
 *
 * Created by: William Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 * @see DeathAction
 */
public class Cliff extends Ground {

    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public void tick(Location location) {
        // If there is an actor standing on the tile, kill it
        if (location.getActor() != null) {
            new DeathAction(location.getActor()).execute(location.getActor(), location.map());
        }
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // Only player can willingly enter
        return (actor.hasCapability(Status.IS_PLAYER));
    }
}
