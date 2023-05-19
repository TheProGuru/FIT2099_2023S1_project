package game.actions;

import Trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;


/**
 * A remake of the death action
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *  Ibrahem Abdul Khalik
 */
public class DespawnAction extends Action {

    public DespawnAction() {
    }

    /**
     * When the target is despawned it simply ceases to exist
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        //unregister weapon
        TradeManager tradeManager = TradeManager.getInstance();
        for(WeaponItem weapon: target.getWeaponInventory()){
            if(tradeManager.getWeapons().contains(weapon)){
                tradeManager.removeWeapon(weapon);
            }
        }
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " vanished.";
    }
}
