package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.Buyable;

public class RemembranceOfTheGrafted extends Item implements Buyable {

    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
    }

    @Override
    public int getSellPrice() {
        return 0;
    }

    @Override
    public int getBuyPrice() {
        return 20000;
    }
}
