package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.runes.RuneManager;

/**
 * An action used to buy an item from a merchant
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class BuyItemAction extends BuyAction {

    /**
     * the item being bought
     */
    private Item item;

    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player involved in trade
     * @param item the item being bought
     * @param buyPrice the buy Price of the item
     */
    public BuyItemAction(Actor merchant, Player player, Item item, int buyPrice) {
        super(merchant, player, buyPrice);
        this.item = item;
    }

    /**
     * adds an Item to the player's Item inventory
     *
     * @param player the Player
     * @param item the item being added
     */
    public void addBuyable(Player player, Item item){
        player.addItemToInventory(item);
    }

    /**
     * When executed, checks if the player has enough runes to buy the item and prints the result of the transaction
     * if successful it subtracts the appropriate amount of runes from the player
     * and adds the item to the player's Item inventory
     * if not it returns an error message
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        // calls upon RuneManager
        RuneManager rm = RuneManager.getInstance();
        // checks if player has enough runes for the transaction
        if(rm.isValidSubtraction(getBuyPrice())){
            String result = actor + " bought " + item + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
            // gives item to player
            addBuyable(getPlayer(), item);
            //subtracts runes from player
            rm.subtractRunes(getBuyPrice());
            return result;
        }
        else {
            return actor + "doesn't have enough runes to buy " + item;
        }
    }

    /**
     * Describes which Item the actor is buying from which merchant for what price
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "buy " + item + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
    }
}
