package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.reset.ResetManager;
import game.reset.Resettable;

import javax.swing.*;

/**
 * The vessel from which the healing juice is stored.
 * Player starts with this in their inventory.
 *
 * Is a limited use item.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Actor
 * @see Resettable
 * @see Consumable
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {

    /**
     * Default number/Max number of uses before needing recharge
     */
    private static final int MAX_USES = 2;
    /**
     * Number of uses remaining
     */
    private int usesRemaining;

    /**
     * Constructor
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'u', false);
        this.usesRemaining = MAX_USES;
        super.addAction(new ConsumeAction(this));
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Uses the item and applies the healing effect to a given actor
     * @param actor Actor to heal
     * @param map current GameMap
     * @return Flavour text describing the outcome of the interaction.
     */
    @Override
    public String use(Actor actor, GameMap map) {
        if (usesRemaining > 0) {
            this.usesRemaining -= 1;
            actor.heal(250);
            return actor + " healed for 250 hit points";
        }
        return this + " is out of charges and did nothing";
    }

    /**
     * Gets the description of the action based on a given actor
     * @param actor Actor to describe the action.
     * @return A relevant description of the action that will be performed
     */
    @Override
    public String getDescription(Actor actor) {
        if (usesRemaining > 0) {
            return this + " heals " + actor + " for 250 hit points (" + usesRemaining + "/" + MAX_USES + ")";
        }
        return this + " is out of charges";
    }

    /**
     * Resets the number of uses back to default/max
     */
    @Override
    public void reset(GameMap map) {
        this.usesRemaining = MAX_USES;
    }
}
