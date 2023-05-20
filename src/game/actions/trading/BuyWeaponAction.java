package game.actions.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.items.runes.RuneManager;

public class BuyWeaponAction extends BuyAction {
    private WeaponItem weapon;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param weapon the item being bought
     */
    public BuyWeaponAction(Actor merchant, Player player, WeaponItem weapon, int buyPrice) {
        super(merchant, player, buyPrice);
        this.weapon = weapon;
    }
    /**
     * adds a Buyable to the players valuable inventory as well as
     * based on if the Buyable belongs in the Item or Weapon inventory of the player
     *
     * @param player the Player
     * @param weapon the item being bought
     */
    public void addBuyable(Player player, WeaponItem weapon){
        player.addWeaponToInventory(weapon);
    }

    /**
     * When executed, checks if the player has enough runes to buy the item
     * if so it subtracts the runes from the player and adds the item in player inventory
     * if not it returns an error message
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {


        RuneManager rm = RuneManager.getInstance();
        if(rm.isValidSubtraction(getBuyPrice())){
            String result = actor + " bought " + weapon + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
            addBuyable(getPlayer(), weapon);
            rm.subtractRunes(getBuyPrice());
            return result;
        }
        else {
            return actor + "doesn't have enough runes to buy " + weapon;
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "buy " + weapon + " from " + getMerchant() + " for " + getBuyPrice() + " runes";
    }
}
