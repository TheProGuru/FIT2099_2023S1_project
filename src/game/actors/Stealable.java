package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Stealable {

    String takeItem(Item item, Actor actor, GameMap map);
}
