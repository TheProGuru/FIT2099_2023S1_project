package game.actions;

import Trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellItemAction extends Action {
    private Actor merchant;
    /**
     * the Player
     */
    private Player player;
    /**
     * the item being bought
     */
    private Item item;
    private int sellPrice;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param item the item being bought
     */
    public SellItemAction(Actor merchant, Player player, Item item, int sellPrice) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
        this.sellPrice = sellPrice;
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
        rm.addRunes(sellPrice);
        tradeManager.removeItem(item);
        String result = actor + " sold " + item + " to " + merchant + " for " + sellPrice+ " runes";
        removeItem(player, item);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + item + " to " + merchant + " for " + sellPrice + " runes";
    }
}
