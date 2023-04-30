package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;

public class RunePile extends Item {

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public RunePile() {
        super("Pile Of Runes", '$', true);
    }

//    @Override
//    public DropAction getDropAction(Actor actor) {
//        return super.getDropAction(actor);
//    }
}
