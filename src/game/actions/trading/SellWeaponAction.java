package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellWeaponAction extends SellAction {
    /**
     * the weapon being sold
     */
    private WeaponItem weapon;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the trade
     * @param player the Player
     * @param weapon the item being sold
     * @param sellPrice the sell Price of the item
     */
    public SellWeaponAction(Actor merchant, Player player, WeaponItem weapon, int sellPrice) {
        super(merchant, player, sellPrice);
        this.weapon = weapon;
    }
    /**
     * removes a weapon from the player's weapon inventory
     *
     * @param player the Player
     * @param weapon the item being removed
     */
    public void removeWeapon(Player player, WeaponItem weapon) {
        WeaponItem tempWeapon = null;
        for (WeaponItem playerWeapon : player.getWeaponInventory()) {
            if (playerWeapon == weapon) {
                tempWeapon = weapon;
            }
        }
        if (tempWeapon != null){
            player.removeWeaponFromInventory(tempWeapon);
        }
    }
    /**
     * When executed, it adds the runes to the player and removes the weapon from the player's weapon inventory
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
        // unregisters weapon with tradeManager
        tradeManager.removeWeapon(weapon);
        String result = actor + " sold " + weapon + " to " + getMerchant() + " for " + getSellPrice()+ " runes";
        // removes weapon from player
        removeWeapon(getPlayer(), weapon);
        return result;
    }
    /**
     * Describes which weapon the actor is selling to which merchant for what price
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + weapon + " to " + getMerchant() + " for " + getSellPrice() + " runes";
    }
}
