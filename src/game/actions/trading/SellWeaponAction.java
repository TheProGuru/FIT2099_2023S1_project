package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellWeaponAction extends SellAction {
    private WeaponItem weapon;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param weapon the item being bought
     */
    public SellWeaponAction(Actor merchant, Player player, WeaponItem weapon, int sellPrice) {
        super(merchant, player, sellPrice);
        this.weapon = weapon;
    }
    /**
     * removes a Buyable from the players valuable inventory as well as
     * based on if the Buyable belongs in the Item or Weapon inventory of the player
     *
     * @param player the Player
     * @param weapon the item being bought
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
        tradeManager.removeWeapon(weapon);
        String result = actor + " sold " + weapon + " to " + getMerchant() + " for " + getSellPrice()+ " runes";
        removeWeapon(getPlayer(), weapon);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + weapon + " to " + getMerchant() + " for " + getSellPrice() + " runes";
    }
}
