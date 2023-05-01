package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.AreaAttackAction;
import game.actions.Buyable;
import game.actors.Player;

import java.util.ArrayList;

/**
 * A curved sword that can be used to attack the enemy.
 * It deals 115 damage with 85% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem implements Buyable {

   private boolean isattakActionAvailable = false;

    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slashes", 85);
    }

    public void removeAreaAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(AreaAttackAction.class)){
                this.removeAction(getAllowableActions().get(i));
                i --;
                isattakActionAvailable = false;
            }
        }
    }
     @Override
    public void tick(Location currentLocation, Actor actor) {
        boolean isActorAround = false;
         ArrayList<Actor> targetlist = new ArrayList<>();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                isActorAround = true;
                targetlist.add(destination.getActor());
            }
        }

        removeAreaAction();

        if(isActorAround){
            AreaAttackAction areaAttackAction = new AreaAttackAction(targetlist, this);
            this.addAction(areaAttackAction);
            this.isattakActionAvailable = true;
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
    public void handlePurchase(Player player) {
        player.addValuable(this);
        player.addWeaponToInventory(this);
    }

    @Override
    public void handleSale(Player player) {
        player.removeValuable(this);
        player.removeWeaponFromInventory(this);
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public int getBuyPrice() {
        return 0;
    }
}