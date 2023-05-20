package game.items.weapons;

import game.Status;
import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.combat.AreaAttackAction;
/**
 * A  weapon that can be used to attack the enemy. it has an  area attack special skill.
 * It deals 89 damage with 90% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class GraftedDragon extends WeaponItem {

    /**
     * Constructor
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89 , "Scorches", 90);
        TradeManager tm = TradeManager.getInstance();
        tm.registerWeapon(this);
    }

    /**
     * removes any area attack actions present in the weapons allowable actions
     */
    public void removeAreaAction(){
        for (int i = 0; i < this.getAllowableActions().size(); i++) {
            if (getAllowableActions().get(i).getClass().equals(AreaAttackAction.class)) {
                this.removeAction(getAllowableActions().get(i));
                i --;
            }
        }
    }

    /**
     * checks the surroundings of the current location and adds an area attack action to the weapons allowable actions
     * if a non-friendly actor is around
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        removeAreaAction();
        boolean isActorAround = false;
        boolean actorIsHoldingWeapon = false;
        for (WeaponItem weapon: actor.getWeaponInventory()){
            if (weapon == this) {
                actorIsHoldingWeapon = true;
            }
        }
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.FRIENDLY)) {
                isActorAround = true;
            }
        }
        if (isActorAround && actorIsHoldingWeapon) {
            this.addAction(getSkill(actor));
        }
    }

    /**
     * gets the weapons active skill
     *
     * @param holder weapon holder
     * @return an area attack action
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}

