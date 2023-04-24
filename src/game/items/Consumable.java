package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;


/**
 * Interface for consumables
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Actor
 * @see GameMap
 */
public interface Consumable {

    /**
     * Uses the instance and performs any required actions.
     * @param actor Relevant Actor to the action
     * @param map Relevant GameMap to the action
     * @return Flavour text representing the outcome of the action
     */
    String use(Actor actor, GameMap map);

    /**
     * Gets a Description of the action based on a given actor.
     * @param actor Actor to describe in relation to
     * @return Flavour text describing the interaction
     */
    String getDescription(Actor actor);

}
