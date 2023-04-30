package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class DropRuneAction extends DropAction {

    private final Item item;
    /**
     * Constructor.
     *
     * @param item the item to drop
     */
    public DropRuneAction(Item item) {
        super(item);
        this.item = item;
    }
    /**
     * When executed, add the dropped item to the game map
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the action suitable for feedback in the UI
     */
//    @Override
    public String execute(Player actor, GameMap map) {
        map.locationOf(actor).addItem(item);
        return menuDescription(actor);
    }
}
