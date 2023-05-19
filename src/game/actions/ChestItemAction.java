package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.Chest;

public class ChestItemAction extends Action {

    private Chest chest;
    private Item item;

    public ChestItemAction(Item item, Chest chest) {
        this.chest = chest;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return chest.pickupItem(item, actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drew " + item + " from " + chest;
    }
}
