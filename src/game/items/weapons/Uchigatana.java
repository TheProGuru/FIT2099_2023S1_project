package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.Unsheathe;

/**
 * A katana that can be used to attack the enemy.
 * It deals 115 damage with 80% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {

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
}
