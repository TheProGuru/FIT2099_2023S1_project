package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class BuyWeaponAction extends BuyAction {
    /**
     * the weapon being bought
     */
    private WeaponItem weapon;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player involved in trade
     * @param weapon the weapon being bought
     * @param buyPrice the buy Price of the item
     */
    public BuyWeaponAction(Actor merchant, Player player, WeaponItem weapon, int buyPrice) {
        super(merchant, player, buyPrice);
        this.weapon = weapon;
    }
    /**
     * adds a weapon to the player's weapon inventory
     *
     * @param player the Player
     * @param weapon the weapon being added
     */
    public void addBuyable(Player player, WeaponItem weapon){
        player.addWeaponToInventory(weapon);
    }

    /**
     * When executed, checks if the player has enough runes to buy the weapon and prints the result of the transaction
     * if successful it subtracts the appropriate amount of runes from the player
     * and adds the weapon to the player's weapon inventory
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
            String result = actor + " bought " + weapon + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
            // gives weapon to player
            addBuyable(getPlayer(), weapon);
            //subtracts runes from player
            rm.subtractRunes(getBuyPrice());
            return result;
        }
        else {
            return actor + "doesn't have enough runes to buy " + weapon;
        }
    }
    /**
     * Describes which weapon the actor is buying from which merchant for what price
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */

    @Override
    public String menuDescription(Actor actor) {
        return "buy " + weapon + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
    }
}
