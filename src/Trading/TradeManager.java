package Trading;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyItemAction;
import game.actions.BuyWeaponAction;
import game.actions.SellItemAction;
import game.actions.SellWeaponAction;
import game.actors.Merchant;
import game.actors.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeManager {
    private static TradeManager instance;
    private ArrayList<WeaponItem> weapons;
    private ArrayList<Item> items;
    private ArrayList<Merchant> merchants;
    private Map<Merchant , Map<String, List<Integer> >> merchantPriceList = new HashMap<>();
    private Map<Merchant , ArrayList<WeaponItem>> merchantWeaponList = new HashMap<>();
    private Map<Merchant , ArrayList<Item>> merchantItemList = new HashMap<>();
    private Player player;

    public TradeManager(){
        this.weapons = new ArrayList<>();
        this.items = new ArrayList<>();
        this.merchants = new ArrayList<>();
    }

    public static TradeManager getInstance(){
        // If TradeManager hasn't yet been instantiated
        if (TradeManager.instance == null){
            TradeManager.instance = new TradeManager();
        }
        return TradeManager.instance;
    }


    public ActionList checkForTrades(Merchant merchant){
        ActionList tradeList = new ActionList();
        if(player != null) {
            for (WeaponItem weapon: merchantWeaponList.get(merchant)){
                int buyPrice = merchantPriceList.get(merchant).get(weapon.toString()).get(1);
                tradeList.add(new BuyWeaponAction(merchant, player, weapon, buyPrice));
            }
            for (Item item: merchantItemList.get(merchant)){
                int buyPrice = merchantPriceList.get(merchant).get(item.toString()).get(1);
                tradeList.add(new BuyItemAction(merchant, player, item, buyPrice));
            }
            for (WeaponItem weapon : player.getWeaponInventory()) {
                for (WeaponItem registeredWeapon : weapons) {
                    if (weapon.equals(registeredWeapon)) {
                        int sellPrice = merchantPriceList.get(merchant).get(weapon.toString()).get(0);
                        tradeList.add(new SellWeaponAction(merchant, player, weapon, sellPrice));
                    }
                }
            }
            for (Item item : player.getItemInventory()) {
                for (Item registeredItem : items) {
                    if (item == registeredItem) {
                        int sellPrice = merchantPriceList.get(merchant).get(item.toString()).get(0);
                        tradeList.add(new SellItemAction(merchant, player, item, sellPrice));
                    }
                }
            }
        }
        return tradeList;
    }
    public void registerPlayer(Player player){
        this.player = player;
    }
    public void registerWeapon(WeaponItem weapon){
        this.weapons.add(weapon);
    }
    public void removeWeapon(WeaponItem weapon){
        this.weapons.remove(weapon);
    }
    public void registerItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }
    public void registerMerchant(Merchant merchant, Map<String, List<Integer>> priceList,
                                 ArrayList<WeaponItem> weaponList, ArrayList<Item> itemList){
        this.merchants.add(merchant);
        this.merchantPriceList.put(merchant, priceList);
        this.merchantWeaponList.put(merchant, weaponList);
        this.merchantItemList.put(merchant, itemList);
    }
}
