package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellItemAction extends SellAction {
    private Item item;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param item the item being bought
     */
    public SellItemAction(Actor merchant, Player player, Item item, int sellPrice) {
        super(merchant, player, sellPrice);
        this.item = item;
    }
    /**
     * removes a Buyable from the players valuable inventory as well as
     * based on if the Buyable belongs in the Item or Weapon inventory of the player
     *
     * @param player the Player
     * @param item the item being bought
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
        TradeManager tradeManager = TradeManager.getInstance();
        rm.addRunes(getSellPrice());
        tradeManager.removeItem(item);
        String result = actor + " sold " + item + " to " + getMerchant() + " for " + getSellPrice()+ " runes";
        removeItem(getPlayer(), item);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + item + " to " + getMerchant() + " for " + getSellPrice() + " runes";
    }
}
