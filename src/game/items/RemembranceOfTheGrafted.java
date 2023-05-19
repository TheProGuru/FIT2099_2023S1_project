package game.items;

import Trading.TradeManager;
import edu.monash.fit2099.engine.items.Item;

public class RemembranceOfTheGrafted extends Item {

    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        TradeManager tm = TradeManager.getInstance();
        tm.registerItem(this);
    }
}
