package game.items;

import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.weapons.AxeofGodrick;
import game.items.weapons.GraftedDragon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Item that Godrick the Grafted drops when defeated
 * it can be sold or swapped
 * Created by:
 * @author
 * Modified by:
 *
 */
public class RemembranceOfTheGrafted extends Item {

    /**
     * Constructor
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        TradeManager tm = TradeManager.getInstance();
        tm.registerItem(this);
        ArrayList<WeaponItem> swapList = new ArrayList<>(Arrays.asList(new GraftedDragon(), new AxeofGodrick()));
        tm.registerSwappable(this, swapList);
    }
}
