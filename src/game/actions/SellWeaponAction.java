package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class SellWeaponAction extends Action {
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
    private WeaponItem weapon;
    private int sellPrice;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param weapon the item being bought
     */
    public SellWeaponAction(Actor merchant, Player player, WeaponItem weapon, int sellPrice) {
        this.merchant = merchant;
        this.player = player;
        this.weapon = weapon;
        this.sellPrice = sellPrice;
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
        //Item tempItem = null;
        for (WeaponItem playerWeapon : player.getWeaponInventory()) {
            if (playerWeapon == weapon) {
                tempWeapon = weapon;
            }
        }
        if (tempWeapon != null){
            player.removeWeaponFromInventory(tempWeapon);
        }
        /*for (Item item : player.getItemInventory()) {
            if (buyable == item) {
                tempItem = item;
            }
        }
        if (tempItem != null){
            player.removeItemFromInventory(tempItem);
        }*/
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
        rm.addRunes(sellPrice);
        String result = actor + " sold " + weapon + " to " + merchant + " for " + sellPrice+ " runes";
        removeWeapon(player, weapon);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + weapon + " to " + merchant + " for " + sellPrice + " runes";
    }
}
