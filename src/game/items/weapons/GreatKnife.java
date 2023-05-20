package game.items.weapons;

import game.Status;
import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.combat.Quickstep;

/**
 * A dagger that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */

public class GreatKnife extends WeaponItem {

    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "Stabs", 70);
        TradeManager tm = TradeManager.getInstance();
        tm.registerWeapon(this);
    }

    /**
     * removes any quickstep actions present in the weapons allowable actions
     */
    public void removeQuickstepAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(Quickstep.class)){
                this.removeAction(getAllowableActions().get(i));
                i--;
            }
        }
    }

    /**
     * checks the surroundings of the current location and adds a quickstep action to the weapons allowable actions
     * for each non-friendly actor in its surroundings
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
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

            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.FRIENDLY)) {
                Quickstep quickstep = new Quickstep(destination.getActor(), exit.getName(), this, safeExit);
                this.addAction(quickstep);
            }
        }
    }
}
