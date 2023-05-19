package game.grounds;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.ChestItemAction;
import game.actions.ChestWeaponAction;

import java.util.ArrayList;

public class Chest extends Actor {

    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<WeaponItem> weaponList = new ArrayList<WeaponItem>();

    /**
     * Constructor.
     */
    public Chest() {
        super("Chest", 'm', 10000);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList al = new ActionList();
        for (Item item : itemList) {
            al.add(new ChestItemAction(item, this));
        }
        for (WeaponItem item : weaponList) {
            al.add(new ChestWeaponAction(item, this));
        }
        return al;
    }

    public String pickupItem(Item item, Actor actor, GameMap map) {
        itemList.remove(item);
        new PickUpItemAction(item).execute(actor, map);
        return actor + " drew " + item + " from " + this;

    }

    public String pickupWeapon(WeaponItem item, Actor actor, GameMap map) {
        System.out.println(weaponList.contains(item) + " REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        weaponList.remove(item);
        new PickUpWeaponAction(item).execute(actor, map);
        return actor + " drew " + item + " from " + this;

    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        itemList.add(item);
    }

    public void addWeapon(WeaponItem item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        weaponList.add(item);
    }

    public String toString() {
        return "Chest";
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
