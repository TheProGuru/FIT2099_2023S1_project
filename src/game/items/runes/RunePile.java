package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PickUpRuneAction;
import game.reset.ResetManager;
import game.reset.Resettable;

public class RunePile extends Item implements Resettable {

    private int runes;

    private Location locationOfRunePile;
    /***
     * Constructor.
     *  @param runes int of runes the pile should contain
     */
    public RunePile(int runes,Location location) {
        super("Pile Of Runes", '$', true);
        this.runes = runes;
        this.locationOfRunePile = location;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Returns runes within the pile
     *
     * @return runes    an integer
     */
    public int extractRunes(){ return runes; }

    @Override
    public PickUpRuneAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpRuneAction(this);
        return null;
    }

    @Override
    public void reset(GameMap map) {
        locationOfRunePile.removeItem(this);
    }
    @Override
    public boolean resetOnRest(){return false;}
}
