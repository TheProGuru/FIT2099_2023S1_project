package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.runes.RuneManager;
import game.items.runes.RunePile;

public class PickUpRuneAction extends PickUpAction {

    private final RunePile item;

    public PickUpRuneAction(RunePile item) {
        super(item);
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager.getInstance().addRunes(item.extractRunes());
        map.locationOf(actor).removeItem(item);
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "'actor' picks up 'number' runes"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up " + item.extractRunes() + " runes";
    }
}
