package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;
/**
 * An Action to buy a Buyable from a merchant
 */
public class BuyAction extends Action {
    /**
     * the Merchant involved in the trade
     */
    private Actor merchant;
    /**
     * the Player
     */
    private Player player;
    /**
     * the item being bought
     */
    private Buyable item;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param item the item being bought
     */
    public BuyAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }
    /**
     * adds a Buyable to the players valuable inventory as well as
     * based on if the Buyable belongs in the Item or Weapon inventory of the player
     *
     * @param player the Player
     * @param buyable the item being bought
     */
    public void addBuyable(Player player, Buyable buyable){
        player.addValuable(buyable);
        if (buyable instanceof Weapon){
            player.addWeaponToInventory((WeaponItem) buyable);
        }
        else{
            player.addItemToInventory((Item)buyable);
        }
    }

    /**
     * When executed, checks if the player has enough runes to buy the item
     * if so it subtracts the runes from the player and adds the item in player inventory
     * if not it returns an error message
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {


        RuneManager rm = RuneManager.getInstance();
        if(rm.isValidSubtraction(item.getBuyPrice())){
            String result = actor + " bought " + item + " from " + merchant + " for " + item.getBuyPrice() + " runes";
            addBuyable(player, item);
            rm.subtractRunes(item.getBuyPrice());
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