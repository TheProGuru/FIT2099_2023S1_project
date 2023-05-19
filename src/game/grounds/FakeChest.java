package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ReplaceAction;
import game.actors.enemies.Mimic;
import game.utils.RandomNumberGenerator;

public class FakeChest extends Chest {

    private Location location;

    @Override
    public String pickupItem(Item item, Actor actor, GameMap map) {
        if (trick(item, map)) {
            return "You were tricked by the sneaky Mimic";
        }
        return super.pickupItem(item, actor, map);
    }

    @Override
    public String pickupWeapon(WeaponItem item, Actor actor, GameMap map) {
        if (trick(item, map)) {
            return "You were tricked by the sneaky Mimic";
        }
        return super.pickupWeapon(item, actor, map);
    }

    private boolean trick(Item item, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1,100) < 1) {
            new ReplaceAction(new Mimic(item)).execute(this, map);
            return true;
        }
        return false;
    }

}
