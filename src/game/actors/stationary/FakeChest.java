package game.actors.stationary;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReplaceAction;
import game.actors.enemies.Mimic;
import game.utils.RandomNumberGenerator;

/**
 * Fake Chest actor, doesn't move around, holds items.
 * 
 * Has a chance to turn into a Mimic when interacted with.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 * 
 * @see Chest
 * @see Mimic
 */
public class FakeChest extends Chest {

    /**
     * Chance to turn into a mimic
     */
    private static final int MIMIC_CHANCE = 50;

    @Override
    public String takeItem(Item item, Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1,100) < MIMIC_CHANCE) {
            // Replace this with a Mimic holding the chosen item
            new ReplaceAction(new Mimic(item)).execute(this, map);
            return "You were tricked by the sneaky Mimic";
        }
        // Do normal functionality
        return super.takeItem(item, actor, map);
    }
}
