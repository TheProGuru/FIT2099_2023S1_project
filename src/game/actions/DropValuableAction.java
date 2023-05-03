package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropWeaponAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
/**
 * A drop action class for when dropping valuables
 */
public class DropValuableAction extends DropAction {
    /**
     * Current Buyable
     */
    private final Buyable valuable;

    /**
     * Constructor.
     *
     * @param valuable the Buyable to drop
     */
    public DropValuableAction(Buyable valuable) {
        super((Item)valuable);
        this.valuable = valuable;
    }
    /**
     * remove Valuable form inventory and continue to drop the weapon
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the action suitable for feedback in the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Player player = (Player) actor;
        player.removeValuable(valuable);
        return new DropWeaponAction((WeaponItem)valuable).execute(actor, map);
    }
}
