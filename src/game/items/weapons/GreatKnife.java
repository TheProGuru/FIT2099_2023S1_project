package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.Buyable;
import game.actions.Quickstep;
import game.actors.Player;

/**
 * A dagger that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */

public class GreatKnife extends WeaponItem implements Buyable {

    private boolean isQuickstepAvailable = false;

    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "Stabs", 70);
    }

    public void removeQuickstepAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(Quickstep.class)){
                this.removeAction(getAllowableActions().get(i));
                i--;
                isQuickstepAvailable = false;
            }
        }
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {

        removeQuickstepAction();
        Location safeExit = currentLocation;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.canActorEnter(actor)) {
                safeExit = destination;
            }
        }

        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                this.isQuickstepAvailable = true;
                Quickstep quickstep = new Quickstep(destination.getActor(), exit.getName(), this, safeExit);
                this.addAction(quickstep);
            }
        }
    }
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable)
            return getPlayerPickUpAction((Player) actor);
        return null;
    }
    public PickUpAction getPlayerPickUpAction(Player player) {
        if (portable) {
            player.addValuable(this);
            return new PickUpWeaponAction(this);
        }
        return null;
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
        return 350;
    }

    @Override
    public int getBuyPrice() {
        return 3500;
    }
}
