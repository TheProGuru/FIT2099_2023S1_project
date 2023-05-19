package game.actors;

import Trading.TradeManager;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.weapons.*;

import java.util.*;


public class MerchantKale extends Merchant{

    public MerchantKale(){
        super("Merchant Kale",'K',100);
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
        ArrayList<WeaponItem> weaponList = new ArrayList<>(Arrays.asList(new Club(),
                new Uchigatana(), new GreatKnife(), new HeavyCrossbow(), new Staff()));
        ArrayList<Item> itemList = new ArrayList<>();
        TradeManager tm = TradeManager.getInstance();
        tm.registerMerchant(this, priceList, weaponList, itemList);
    }
}