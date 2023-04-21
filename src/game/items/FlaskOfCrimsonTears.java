package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.reset.Resettable;

import javax.swing.*;

/**
 * The vessel from which the healing juice is stored.
 * Player starts with this in their inventory.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see game.actors.Player
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {

    /**
     * Default number/Max number of uses before needing recharge
     */
    private static final int MAX_USES = 2;
    private int usesRemaining;

    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'u', false);
        this.usesRemaining = MAX_USES;
        super.addAction(new ConsumeAction(this));
    }

    @Override
    public void reset() {
        this.usesRemaining = MAX_USES;
    }


    @Override
    public String use(Actor actor, GameMap map) {
        if (usesRemaining > 0) {
            this.usesRemaining -= 1;
            actor.heal(250);
            return actor + "healed for 250 hit points";
        }
        return this + "is out of charges and did nothing";
    }

    @Override
    public String getDescription(Actor actor) {
        if (usesRemaining > 0) {
            return this + " heals " + actor + "for 250 hit points";
        }
        return this + " is out of charges";
    }

    public String toString() {
        return super.toString();
    }
}
