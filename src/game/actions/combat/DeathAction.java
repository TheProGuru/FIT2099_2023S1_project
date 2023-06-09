package game.actions.combat;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.ReplaceAction;
import game.actions.ResetAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.Family;
import game.actors.enemies.PileOfBones;
import game.grounds.SiteOfLostGrace;
import game.items.runes.RuneManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * The whole team
 */
public class DeathAction extends Action {

    private final Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";


        if(target.hasCapability(Status.IS_PLAYER)){
            // If the Player dies
            new ResetAction().execute(target, map);
            return result;
        }
        else if(target.getDisplayChar() == 'q'){
            new ReplaceAction(new PileOfBones()).execute(target, map);
            return "\nHeavy Skeletal Swordsman has fallen and cant get up";
        }
        else if (target.hasCapability(Family.BOSS)) {
            ActionList dropActions = new ActionList();
            // drop all items only (no weapons)
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);

            //create the lost grace
            map.locationOf(target).setGround(new SiteOfLostGrace("Godrick the Grafted"));

            //generate runes for the player
            Enemy enemy = (Enemy) target;
            RuneManager.getInstance().addRunes(enemy.generateRunes());
        }
        else if (attacker.hasCapability(Status.IS_PLAYER)) {
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);

            //generate runes for the player
            Enemy enemy = (Enemy) target;
            RuneManager.getInstance().addRunes(enemy.generateRunes());
        }
        // remove actor
        map.removeActor(target);
        //print result
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
