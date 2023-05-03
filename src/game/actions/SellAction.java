package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;
/**
 * An Action to sell a Buyable to a merchant
 */
public class SellAction extends Action {
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
    public SellAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }
    /**
     * removes a Buyable from the players valuable inventory as well as
     * based on if the Buyable belongs in the Item or Weapon inventory of the player
     *
     * @param player the Player
     * @param buyable the item being bought
     */
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
    /**
     * When executed, it adds the runes to the player and removes the item from the player inventory
     * also adds the runes from the sale to the player
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
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
