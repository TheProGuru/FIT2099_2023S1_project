package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface for actors that can have items taken from them
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see game.actions.StealAction
 */
public interface Stealable {

    /**
     * Attempts to take the item from the stealable
     * @param item Item to take
     * @param actor Actor to give the Item to
     * @param map Map that the interaction is taking place on
     * @return Descriptive String
     */
    String takeItem(Item item, Actor actor, GameMap map);
}
