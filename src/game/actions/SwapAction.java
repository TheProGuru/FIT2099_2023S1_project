package game.actions;

import Trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;

public class SwapAction extends Action {
    private Actor merchant;
    /**
     * the Player
     */
    private Player player;
    /**
     * the item being bought
     */
    private Item item;
    private WeaponItem weapon;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the trade
     * @param player the Player
     * @param item the item being bought
     */
    public SwapAction(Actor merchant, Player player, Item item, WeaponItem weapon) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
        this.weapon = weapon;
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
    public void addWeapon(Player player, WeaponItem weapon){
        player.addWeaponToInventory(weapon);
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

        TradeManager tradeManager = TradeManager.getInstance();
        tradeManager.removeItem(item);
        tradeManager.removeSwappable(item);
        String result = actor + " gave " + item + " to " + merchant + " for " + weapon ;
        removeItem(player, item);
        addWeapon(player, weapon);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "give " + item + " to " + merchant + " for " + weapon;
    }
}
