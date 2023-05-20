package game.actions.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

/**
 * An action used to sell an item to a merchant
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public abstract class SellAction extends Action {

    /**
     * the Merchant involved in the trade
     */
    private Actor merchant;

    /**
     * the Player involved in trade
     */
    private Player player;

    /**
     * the sell Price of the item
     */
    private int sellPrice;

    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     * @param sellPrice the sell Price of the item
     */
    public SellAction(Actor merchant, Player player, int sellPrice) {
        this.merchant = merchant;
        this.player = player;
        this.sellPrice = sellPrice;
    }

    /**
     *
     * @return the Merchant involved in the trade
     */
    public Actor getMerchant() {
        return merchant;
    }

    /**
     *
     * @return the Player involved in trade
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @return the buy Price of the item
     */
    public int getSellPrice() {
        return sellPrice;
    }
}
