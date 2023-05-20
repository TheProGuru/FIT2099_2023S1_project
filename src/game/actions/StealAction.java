package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Stealable;

/**
 * Action to steal items from other actors.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Stealable
 */
public class StealAction extends Action {

    /**
     * Stealable to take from
     */
    private final Stealable stealable;
    /**
     * Item to take from Stealable
     */
    private final Item item;

    /**
     * Constructor
     * @param item Item to take
     * @param stealable Stealable holding the item
     */
    public StealAction(Item item, Stealable stealable) {
        this.stealable = stealable;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return stealable.takeItem(item, actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " took " + item + " from " + stealable;
    }
}
