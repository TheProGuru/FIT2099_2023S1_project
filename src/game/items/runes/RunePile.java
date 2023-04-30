package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actions.PickUpRuneAction;

public class RunePile extends Item {

    private int runes;
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public RunePile(int runes) {
        super("Pile Of Runes", '$', true);
        this.runes = runes;
    }

    /**
     * Returns runes within the pile
     *
     * @return runes    an integer
     */
    public int extractRunes(){ return runes; }

//    @Override
//    public DropAction getDropAction(Actor actor) {
//        return super.getDropAction(actor);
//    }

    @Override
    public PickUpRuneAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpRuneAction(this);
        return null;
    }
}
