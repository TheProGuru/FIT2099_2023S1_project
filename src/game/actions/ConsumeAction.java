package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * Generic Consume Action
 *
 * @author William Bata-Kindermann
 * @see Action
 * @see Consumable
 */
public class ConsumeAction extends Action {

    /**
     * The consumable to consume
     */
    Consumable source;

    /**
     * Constructor
     * @param source The consumable to consume
     */
    public ConsumeAction(Consumable source) {
        this.source = source;
    }

    /**
     * Executes the consumables effect
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Description of the outcome
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return source.use(actor, map);
    }

    /**
     * Returns menu flavour text
     * @param actor The actor performing the action.
     * @return A description of what the consumable will do
     */
    @Override
    public String menuDescription(Actor actor) {
        return source.getDescription(actor);
    }
}
