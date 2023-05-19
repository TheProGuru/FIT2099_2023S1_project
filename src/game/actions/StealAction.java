package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Stealable;

public class StealAction extends Action {

    private final Stealable stealable;
    private final Item item;

    public StealAction(Item item, Stealable stealable) {
        this.stealable = stealable;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return stealable.takeItem(item, actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drew " + item + " from " + stealable;
    }
}
