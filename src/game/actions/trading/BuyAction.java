package game.actions.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

public abstract class BuyAction extends Action {
    /**
     * the Merchant involved in the trade
     */
    private Actor merchant;
    /**
     * the Player
     */
    private Player player;
    private int buyPrice;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     */
    public BuyAction(Actor merchant, Player player, int buyPrice) {
        this.merchant = merchant;
        this.player = player;
        this.buyPrice = buyPrice;
    }

    public Actor getMerchant() {
        return merchant;
    }

    public Player getPlayer() {
        return player;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
