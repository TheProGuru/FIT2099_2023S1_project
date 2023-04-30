package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.Buyable;
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

    private boolean isUnsheatheAvailable = false;

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
                isUnsheatheAvailable = false;
            }
        }
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {

        removeUnsheatheAction();
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                this.isUnsheatheAvailable = true;
                Unsheathe unsheathe = new Unsheathe(destination.getActor(), exit.getName(), this);
                this.addAction(unsheathe);
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
        return 500;
    }

    @Override
    public int getBuyPrice() {
        return 5000 ;
    }
}
