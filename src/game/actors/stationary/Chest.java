package game.actors.stationary;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.StealAction;
import game.actors.Stealable;

/**
 * Chest actor, doesn't move around, holds items.
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Stealable
 * @see StealAction
 */
public class Chest extends Actor implements Stealable {

    /**
     * Constructor.
     */
    public Chest() {
        super("Chest", 'm', 1337);
    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList al = new ActionList();
        // Advertise steal action for every item in the chest
        for (Item item : this.getItemInventory()) {
            al.add(new StealAction(item, this));
        }
        return al;
    }

    public String takeItem(Item item, Actor actor, GameMap map) {
        // Give the player the Item
        this.removeItemFromInventory(item);
        item.getPickUpAction(actor).execute(actor, map);
        return actor + " drew " + item + " from " + this;

    }

    public String toString() {
        return "Chest";
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
