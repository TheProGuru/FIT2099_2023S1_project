package game.actions.combat;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

/**
 * An Action to attack all other Actors in the surroundings.
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class AreaAttackAction extends Action {

    /**
     * The list of targets
     */
    ArrayList<Actor> targetList = new ArrayList<>();

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * sets the weapon used for the attack
     *
     * @param weapon the weapon used for the attack
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * When executed, each exit of the location of the actor is checked, if there is an actor around then:
     * the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether if each target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "Area Attack is in progress by " + actor +"\n";
        //looks at the surrounding tiles
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            //if an actor exist on the tile we keep track of the actor
            if (destination.containsAnActor()) {
                this.targetList.add(destination.getActor());
            }
        }
        //start an attack process on all the actors we have looked at
        for(Actor target: targetList){
            if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
               result = result + actor + " misses " + target + ".\n";
            }
            else{
                int damage = weapon.damage();
                result = result + actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.\n";
                target.hurt(damage);
                if (!target.isConscious()) {
                    result += new DeathAction(actor).execute(target, map) + "\n";
                }
            }
        }
        return result;
    }

    /**
     * Describes that the Actor can start an area attack action
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " area attacks all the actors surrounding";
    }
}