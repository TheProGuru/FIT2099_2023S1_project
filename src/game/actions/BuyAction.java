package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class BuyAction extends Action {

    private Actor merchant;
    private Actor player;

    private Buyable item;

    public BuyAction(Actor merchant, Actor player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        String result =  " Sell " + item + " to " + merchant + " for x runes";// ADD RUNES
        player.removeWeaponFromInventory((WeaponItem) item);
        // UPDATE PLAYERS RUNES
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sold " + item + " to " + merchant + " for x runes"; // ADD RUNES
    }
}
