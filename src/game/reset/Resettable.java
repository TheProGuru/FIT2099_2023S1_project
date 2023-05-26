package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 *
 * Created by: Adrian Kristanto
 *
 * @see ResetManager
 */
public interface Resettable {

    /**
     * Method to reset the instance on game reset
     * @param map the game map
     */
    void reset(GameMap map);

    /**
     * Gets whether an instance resets on soft game reset/rest
     * @return true if resets on rest, false otherwise
     */
    default boolean resetOnRest(){return true;}
}
