package game.actions.combat;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * An Action to attack another Actor and dashing into a safe space.
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class Quickstep extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;
    /**
     * the Location the actor ends up on after performing the skill
     */
    private Location safeExit;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon Weapon used for the attack
     * @param safeExit the Location the actor ends up on after performing the skill
     */
    public Quickstep(Actor target, String direction, Weapon weapon, Location safeExit) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
        this.safeExit = safeExit;
    }

    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     * if attack is successful the actor performing the attack is moved to a safe exit in its surroundings(if one exists)
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack and where the actor moved to if attack was successful, e.g. whether the target
     * is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage using Quickstep";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }
        map.moveActor(actor, safeExit);
        result += "\n" + actor + " dodged to " + safeExit.x() +","+ safeExit.y();
        return result;
    }

    /**
     * Describes which target the actor is attacking with which weapon at which direction with which skill
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " Using Quickstep";
    }
}
