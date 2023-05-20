package game.items.weapons;

import game.Status;
import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.combat.Unsheathe;

/**
 * A katana that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {


    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "Slices", 80);
        TradeManager tm = TradeManager.getInstance();
        tm.registerWeapon(this);
    }
    /**
     * removes any unsheathe attack actions present in the weapons allowable actions
     */
    public void removeUnsheatheAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(Unsheathe.class)){
                this.removeAction(getAllowableActions().get(i));
                i--;
            }
        }
    }
    /**
     * checks the surroundings of the current location and adds an unsheathe action to the weapons allowable actions
     * for each non-friendly actor in its surroundings
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {

        removeUnsheatheAction();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.FRIENDLY)) {
                Unsheathe unsheathe = new Unsheathe(destination.getActor(), exit.getName(), this);
                this.addAction(unsheathe);
            }
        }
    }
}
