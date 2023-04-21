package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

public class ConsumeAction extends Action {

    Consumable source;

    public ConsumeAction(Consumable source) {
        this.source = source;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return source.use(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return source.getDescription(actor);
    }
}
