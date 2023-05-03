package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropWeaponAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.Buyable;
import game.actions.DropValuableAction;
import game.actions.Unsheathe;
import game.actors.Player;

/**
 * A katana that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements Buyable {


    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "Slices", 80);
    }

    public void removeUnsheatheAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(Unsheathe.class)){
                this.removeAction(getAllowableActions().get(i));
                i--;
            }
        }
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {

        removeUnsheatheAction();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                Unsheathe unsheathe = new Unsheathe(destination.getActor(), exit.getName(), this);
                this.addAction(unsheathe);
            }
        }
    }

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
        return 500;
    }

    @Override
    public int getBuyPrice() {
        return 5000 ;
    }
}
