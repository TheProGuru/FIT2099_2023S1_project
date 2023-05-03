package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class BuyAction extends Action {

    private Actor merchant;
    private Player player;

    private Buyable item;

    public BuyAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }
    public void addBuyable(Player player, Buyable buyable){
        player.addValuable(buyable);
        if (buyable instanceof Weapon){
            player.addWeaponToInventory((WeaponItem) buyable);
        }
        else{
            player.addItemToInventory((Item)buyable);
        }
    }

    @Override
    public String execute(Actor actor, GameMap map) {


        RuneManager rm = RuneManager.getInstance();
        if(rm.isValidSubtraction(item.getBuyPrice())){
            String result = actor + " bought " + item + " from " + merchant + " for " + item.getBuyPrice() + " runes";
            addBuyable(player, item);
            return result;
        }
        else {
            return actor + "doesn't have enough runes to buy " + item;
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "buy " + item + " from " + merchant + " for " + item.getBuyPrice() + " runes";
    }
}