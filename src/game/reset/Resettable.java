package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public interface Resettable {
    void reset(GameMap map);

    default boolean resetOnRest(){return true;}
}
