package game.actions.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;

/**
 * An action used to swap an item with a weapon
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class SwapAction extends Action {

    /**
     * the Merchant involved in the swap
     */
    private Actor merchant;

    /**
     * the Player involved in swap
     */
    private Player player;

    /**
     * the item being swapped
     */
    private Item item;

    /**
     * the weapon the item is being swapped with
     */
    private WeaponItem weapon;

    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the swap
     * @param player the Player involved in swap
     * @param item the item being swapped
     * @param weapon the weapon the item is being swapped with
     */
    public SwapAction(Actor merchant, Player player, Item item, WeaponItem weapon) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
        this.weapon = weapon;
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
     * adds a weapon to the player's weapon inventory
     *
     * @param player the Player
     * @param weapon the weapon being added
     */
    public void addWeapon(Player player, WeaponItem weapon){
        player.addWeaponToInventory(weapon);
    }

    /**
     * When executed, it swaps the item with the weapon and prints the result
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        // calls upon TradeManager
        TradeManager tradeManager = TradeManager.getInstance();
        // unregisters item with tradeManager
        tradeManager.removeItem(item);
        // unregisters swappable with tradeManager
        tradeManager.removeSwappable(item);
        String result = actor + " gave " + item + " to " + merchant + " for " + weapon ;
        // removes item from player
        removeItem(player, item);
        // gives weapon to player
        addWeapon(player, weapon);
        return result;
    }

    /**
     * Describes which Item the actor is swapping with which merchant for which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "give " + item + " to " + merchant + " for " + weapon;
    }
}
