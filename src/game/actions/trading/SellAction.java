package game.actions.trading;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

public abstract class SellAction extends Action {
    private Actor merchant;
    /**
     * the Player
     */
    private Player player;
    private int sellPrice;
    /**
     * Constructor.
     *
     * @param merchant the Merchant involved in the tradek
     * @param player the Player
     */
    public SellAction(Actor merchant, Player player, int sellPrice) {
        this.merchant = merchant;
        this.player = player;
        this.sellPrice = sellPrice;
    }

    public Actor getMerchant() {
        return merchant;
    }

    public Player getPlayer() {
        return player;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
