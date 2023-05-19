package game.actors;

import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.*;

public class FingerReaderEnia extends Merchant{
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 100);
        Map<String, List<Integer>> priceList = new HashMap<>();
        List<Integer> prices = Arrays.asList(100, 600);
        priceList.put("Club", prices);
        prices = Arrays.asList(500, 5000);
        priceList.put("Uchigatana", prices);
        prices = Arrays.asList(350, 3500);
        priceList.put("Great Knife", prices);
        prices = Arrays.asList(100, 1500);
        priceList.put("Heavy Crossbow", prices);
        prices = Arrays.asList(100 , 800 );
        priceList.put("Staff", prices);
        prices = Arrays.asList(20000 , 0 );
        priceList.put("Remembrance of the Grafted", prices);
        prices = Arrays.asList(100 , 0 );
        priceList.put("Axe of Godrick", prices);
        prices = Arrays.asList(200 , 0 );
        priceList.put("Grafted Dragon", prices);
        ArrayList<WeaponItem> weaponList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        TradeManager tm = TradeManager.getInstance();
        tm.registerMerchant(this, priceList, weaponList, itemList);
        tm.registerSwapper(this);
    }
}
