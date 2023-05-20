package game.actions.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

/**
 * An action used to buy an item from a merchant
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public abstract class BuyAction extends Action {

    /**
     * the Merchant involved in the trade
     */
    private Actor merchant;

    /**
     * the Player involved in trade
     */
    private Player player;

    /**
     * the buy Price of the item
     */
    private int buyPrice;

    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the trade
     * @param player the Player involved in trade
     * @param buyPrice the buy Price of the item
     */
    public BuyAction(Actor merchant, Player player, int buyPrice) {
        this.merchant = merchant;
        this.player = player;
        this.buyPrice = buyPrice;
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
    public int getBuyPrice() {
        return buyPrice;
    }
}
