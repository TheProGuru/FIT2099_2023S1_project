package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class SellAction extends Action {

    private Actor merchant;
    private Player player;

    private Buyable item;

    public SellAction(Actor merchant, Player player, Buyable item) {
        this.merchant = merchant;
        this.player = player;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        String result = actor + " sold " + item + " to " + merchant + " for " + item.getSellPrice()+ " runes";
        item.handleSale(player);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + item + " to " + merchant + " for " + item.getSellPrice() + " runes";
    }
}
