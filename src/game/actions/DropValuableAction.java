package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropWeaponAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;

public class DropValuableAction extends DropAction {
    private final Buyable valuable;

    /**
     * Constructor.
     *
     * @param valuable the item to drop
     */
    public DropValuableAction(Buyable valuable) {
        super((Item)valuable);
        this.valuable = valuable;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        Player player = (Player) actor;
        player.removeValuable(valuable);
        return new DropWeaponAction((WeaponItem)valuable).execute(actor, map);
    }
}
