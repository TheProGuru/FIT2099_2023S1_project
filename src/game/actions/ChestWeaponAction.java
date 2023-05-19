package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.grounds.Chest;

public class ChestWeaponAction extends Action {

    private Chest chest;
    private WeaponItem item;

    public ChestWeaponAction(WeaponItem item, Chest chest) {
        this.chest = chest;
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return chest.pickupWeapon(item, actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drew " + item + " from " + chest;
    }
}
