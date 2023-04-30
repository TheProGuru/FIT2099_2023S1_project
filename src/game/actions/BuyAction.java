package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class BuyAction extends Action {

    private Actor merchant;
    private Player player;

    private Buyable item;

    public BuyAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        String result = actor + " bought " + item + " from " + merchant + " for " + item.getBuyPrice() + " runes";
        item.handlePurchase(player);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "buy " + item + " from " + merchant + " for " + item.getBuyPrice() + " runes";
    }
}