package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Consumable {

    String use(Actor actor, GameMap map);

    String getDescription(Actor actor);

    String toString();
}
