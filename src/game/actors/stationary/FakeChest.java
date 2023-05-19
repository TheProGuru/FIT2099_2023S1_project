package game.actors.stationary;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReplaceAction;
import game.actors.enemies.Mimic;
import game.utils.RandomNumberGenerator;

public class FakeChest extends Chest {

    private static final int TRICK_CHANCE = 50;

    @Override
    public String takeItem(Item item, Actor actor, GameMap map) {
        if (trick(item, map)) {
            return "You were tricked by the sneaky Mimic";
        }
        return super.takeItem(item, actor, map);
    }

    private boolean trick(Item item, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1,100) < TRICK_CHANCE) {
            new ReplaceAction(new Mimic(item)).execute(this, map);
            return true;
        }
        return false;
    }

}
