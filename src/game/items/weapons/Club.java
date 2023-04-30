package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.Buyable;
import game.actors.Player;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Buyable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public void BoughtdBy(Actor player) {

    }

    @Override
    public boolean isBuyable() {
        return true;
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable)
            return getPlayerPickUpAction((Player) actor);
        return null;
    }
    public PickUpAction getPlayerPickUpAction(Player player) {
        if (portable) {
            player.addToValuables(this);
            return new PickUpWeaponAction(this);
        }
        return null;
    }

}
