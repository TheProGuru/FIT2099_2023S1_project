package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropWeaponAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.Buyable;
import game.actions.DropValuableAction;
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
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable) {
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                return getPlayerPickUpAction((Player) actor);
            }
            return new PickUpWeaponAction(this);
        }
        return null;
    }
    public PickUpAction getPlayerPickUpAction(Player player) {
        player.addValuable(this);
        return new PickUpWeaponAction(this);
    }
    @Override
    public DropAction getDropAction(Actor actor) {
        if (portable) {
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                return new DropValuableAction(this);
            }
            return new DropWeaponAction(this);
        }
        return null;
    }


    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public int getBuyPrice() {
        return 600 ;
    }
}
