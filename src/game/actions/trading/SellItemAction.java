package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.runes.RuneManager;

/**
 * An action used to sell an item to a merchant
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class SellItemAction extends SellAction {

    /**
     * the item being sold
     */
    private Item item;

    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the trade
     * @param player the Player
     * @param item the item being sold
     * @param sellPrice the sell Price of the item
     */
    public SellItemAction(Actor merchant, Player player, Item item, int sellPrice) {
        super(merchant, player, sellPrice);
        this.item = item;
    }

    /**
     * removes an Item from the player's Item inventory
     *
     * @param player the Player
     * @param item the item being removed
     */
    public void removeItem(Player player, Item item) {
        Item tempItem = null;
        for (Item playeritem : player.getItemInventory()) {
            if (playeritem == item) {
                tempItem = item;
            }
        }
        if (tempItem != null){
            player.removeItemFromInventory(tempItem);
        }
    }

    /**
     * When executed, it adds the runes to the player and removes the item from the player's Item inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        // calls upon RuneManager
        RuneManager rm = RuneManager.getInstance();
        // calls upon TradeManager
        TradeManager tradeManager = TradeManager.getInstance();
        // adds runes to player
        rm.addRunes(getSellPrice());
        // unregisters item with tradeManager
        tradeManager.removeItem(item);
        String result = actor + " sold " + item + " to " + getMerchant() + " for " + getSellPrice()+ " runes";
        // removes item from player
        removeItem(getPlayer(), item);
        return result;
    }

    /**
     * Describes which Item the actor is selling to which merchant for what price
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + item + " to " + getMerchant() + " for " + getSellPrice() + " runes";
    }
}
