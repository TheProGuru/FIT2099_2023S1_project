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

/**
 * A manager that handles all trading and swapping
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class TradeManager {

    /**
     * The singular instance of TradeManager to call statically
     */
    private static TradeManager instance;

    /**
     * list of registered weapons
     */
    private ArrayList<WeaponItem> weapons;

    /**
     * list of registered items
     */
    private ArrayList<Item> items;

    /**
     * list of registered swappables(items that can be swapped)
     */
    private ArrayList<Item> swappables;

    /**
     * list of registered swappers(merchants that can perform a swap action)
     */
    private  ArrayList<Merchant> swappers;

    /**
     * a map of maps, that maps merchants to their own price lists(list of items and their buy,sell prices)
     */
    private Map<Merchant , Map<String, List<Integer> >> merchantPriceList = new HashMap<>();

    /**
     * a map of  merchants to the weapons that they sell
     */
    private Map<Merchant , ArrayList<WeaponItem>> merchantWeaponList = new HashMap<>();

    /**
     * a map of  merchants to the items that they sell
     */
    private Map<Merchant , ArrayList<Item>> merchantItemList = new HashMap<>();

    /**
     * a map of  items to the weapons that they can be swapped with
     */
    private Map<Item, ArrayList<WeaponItem>> swapList = new HashMap<>();

    /**
     * the player involved in the swap
     */
    private Player player;


    /**
     * Constructor (private)
     */
    private TradeManager(){
        this.weapons = new ArrayList<>();
        this.items = new ArrayList<>();
        this.swappables = new ArrayList<>();
        this.swappers = new ArrayList<>();
    }

    /**
     * Returns the singular instance of TradeManager
     * @return The singular instance of TradeManager
     */
    public static TradeManager getInstance(){
        // If TradeManager hasn't yet been instantiated
        if (TradeManager.instance == null){
            TradeManager.instance = new TradeManager();
        }
        return TradeManager.instance;
    }

    /**
     * returns an Action list of swap actions for each registered swappable that the player is holding
     *
     * @param merchant the merchant that the player is interacting with
     * @return an Action list of swapActions
     */
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

    /**
     * returns an Action list of sell actions for each registered item/weapon that the player is holding
     *
     * @param merchant the merchant that the player is interacting with
     * @return an Action list of SellActions
     */
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

    /**
     * returns an Action list of Buy actions for each item/weapon that the merchant can sell
     *
     * @param merchant the merchant that the player is interacting with
     * @return an Action list of BuyActions
     */
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

    /**
     * checks which actions the player can perform with the merchant
     *
     * @param merchant the merchant that the player is interacting with
     * @return an Action list of all valid actions that the player can perform with the merchant
     */
    public ActionList checkForTrades(Merchant merchant){
        ActionList tradeList = new ActionList();
        if(player != null) {
            tradeList.add(checkForSales(merchant));
            tradeList.add(checkForPurchases(merchant));
            if (swappers != null && swappers.contains(merchant)){
                tradeList.add(checkForSwaps(merchant));
            }

        }
        return tradeList;
    }

    /**
     *
     * @return list of registered weapons
     */
    public ArrayList<WeaponItem> getWeapons() {
        return weapons;
    }

    /**
     * registers the player with TradeManager
     *
     * @param player the player to be registered
     */
    public void registerPlayer(Player player){
        this.player = player;
    }

    /**
     * registers the swappable with TradeManager and maps the swapList to the swappable
     *
     * @param swappable the swappable to be registered with TradeManager
     * @param swapList the swapList to be mapped to the swappable
     */
    public void registerSwappable(Item swappable, ArrayList<WeaponItem> swapList){
        this.swappables.add(swappable);
        this.swapList.put(swappable,swapList);
    }

    /**
     * unregisters the swappable with TradeManager
     *
     * @param swappable the swappable to be unregistered with TradeManager
     */
    public void removeSwappable(Item swappable){
        this.swappables.remove(swappable);
    }

    /**
     * registers the weapon with TradeManager
     *
     * @param weapon the weapon to be registered with TradeManager
     */
    public void registerWeapon(WeaponItem weapon){
        this.weapons.add(weapon);
    }

    /**
     * unregisters the weapon with TradeManager
     *
     * @param weapon the weapon to be unregistered with TradeManager
     */
    public void removeWeapon(WeaponItem weapon){
        this.weapons.remove(weapon);
    }

    /**
     * registers the item with TradeManager
     *
     * @param item the item to be registered with TradeManager
     */
    public void registerItem(Item item){
        this.items.add(item);
    }

    /**
     * unregisters the item with TradeManager
     *
     * @param item the item to be registered with TradeManager
     */
    public void removeItem(Item item){
        this.items.remove(item);
    }

    /**
     * registers the swapper with TradeManager
     *
     * @param merchant the swapper to be registered with TradeManager
     */
    public void registerSwapper(Merchant merchant){
        this.swappers.add(merchant);
    }

    /**
     * maps the priceList, the weaponList and the itemList  to the merchant
     *
     * @param merchant the merchant that the lists are being mapped to
     * @param priceList the priceList to be mapped to the merchant
     * @param weaponList the weaponList to be mapped to the merchant
     * @param itemList the itemList to be mapped to the merchant
     */
    public void registerMerchant(Merchant merchant, Map<String, List<Integer>> priceList,
                                 ArrayList<WeaponItem> weaponList, ArrayList<Item> itemList){
        this.merchantPriceList.put(merchant, priceList);
        this.merchantWeaponList.put(merchant, weaponList);
        this.merchantItemList.put(merchant, itemList);
    }
}
