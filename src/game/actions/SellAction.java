package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellAction extends Action {

    private Actor merchant;
    private Player player;

    private Buyable item;

    public SellAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }

    public void removeBuyable(Player player, Buyable buyable){
        player.removeValuable(buyable);
        for(WeaponItem weapon: player.getWeaponInventory()){
            if ( buyable == weapon){
                player.removeWeaponFromInventory(weapon);
            }
        }
        for(Item item: player.getItemInventory()){
            if ( buyable == item){
                player.removeItemFromInventory(item);
            }
        }
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        RuneManager rm = RuneManager.getInstance();
        rm.addRunes(item.getSellPrice());
        String result = actor + " sold " + item + " to " + merchant + " for " + item.getSellPrice()+ " runes";
        removeBuyable(player, item);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + item + " to " + merchant + " for " + item.getSellPrice() + " runes";
    }
}
