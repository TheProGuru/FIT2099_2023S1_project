package game.actions.trading;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
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
    private ArrayList<Item> swappables;
    private  ArrayList<Merchant> swappers;
    private Map<Merchant , Map<String, List<Integer> >> merchantPriceList = new HashMap<>();
    private Map<Merchant , ArrayList<WeaponItem>> merchantWeaponList = new HashMap<>();
    private Map<Merchant , ArrayList<Item>> merchantItemList = new HashMap<>();
    private Map<Item, ArrayList<WeaponItem>> swapList = new HashMap<>();
    private Player player;

    public TradeManager(){
        this.weapons = new ArrayList<>();
        this.items = new ArrayList<>();
        this.merchants = new ArrayList<>();
        this.swappables = new ArrayList<>();
        this.swappers = new ArrayList<>();
    }

    public static TradeManager getInstance(){
        // If TradeManager hasn't yet been instantiated
        if (TradeManager.instance == null){
            TradeManager.instance = new TradeManager();
        }
        return TradeManager.instance;
    }
    public ActionList checkForSwaps(Merchant merchant){
        ActionList tradeList = new ActionList();
        for (Item item : player.getItemInventory()) {
            for (Item swappable : swappables) {
                if(item == swappable){
                    for (WeaponItem weapon: swapList.get(swappable)){
                        tradeList.add(new SwapAction(merchant, player, item, weapon));
                    }
                }
            }
        }
        return tradeList;
    }
    public ActionList checkForSales(Merchant merchant){
        ActionList tradeList = new ActionList();
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
        return tradeList;
    }
    public ActionList checkForPurchases(Merchant merchant){
        ActionList tradeList = new ActionList();
        for (WeaponItem weapon: merchantWeaponList.get(merchant)){
            int buyPrice = merchantPriceList.get(merchant).get(weapon.toString()).get(1);
            tradeList.add(new BuyWeaponAction(merchant, player, weapon, buyPrice));
        }
        for (Item item: merchantItemList.get(merchant)){
            int buyPrice = merchantPriceList.get(merchant).get(item.toString()).get(1);
            tradeList.add(new BuyItemAction(merchant, player, item, buyPrice));
        }
        return tradeList;
    }



    public ActionList checkForTrades(Merchant merchant){
        ActionList tradeList = new ActionList();
        if(player != null) {
            /*for (WeaponItem weapon: merchantWeaponList.get(merchant)){
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
            }*/
            tradeList.add(checkForSales(merchant));
            tradeList.add(checkForPurchases(merchant));
            if (swappers != null && swappers.contains(merchant)){
                tradeList.add(checkForSwaps(merchant));
            }

        }
        return tradeList;
    }

    public ArrayList<WeaponItem> getWeapons() {
        return weapons;
    }

    public void registerPlayer(Player player){
        this.player = player;
    }
    public void registerSwappable(Item swappable, ArrayList<WeaponItem> swapList){
        this.swappables.add(swappable);
        this.swapList.put(swappable,swapList);
    }
    public void removeSwappable(Item swappable){
        this.swappables.remove(swappable);

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
    public void registerSwapper(Merchant merchant){
        this.swappers.add(merchant);
    }
    public void registerMerchant(Merchant merchant, Map<String, List<Integer>> priceList,
                                 ArrayList<WeaponItem> weaponList, ArrayList<Item> itemList){
        this.merchants.add(merchant);
        this.merchantPriceList.put(merchant, priceList);
        this.merchantWeaponList.put(merchant, weaponList);
        this.merchantItemList.put(merchant, itemList);
    }
}
