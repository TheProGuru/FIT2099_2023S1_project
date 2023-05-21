package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.combat.AttackAction;
import game.actors.enemies.Family;
import game.utils.RandomNumberGenerator;
/**
 *
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 * William-Bata-Kindermann
 * Salar Ghadrigolestani
 *
 */
public class AttackBehaviour implements Behaviour{

    /**
     * Returns an AttackAction that targets the player if near
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location locOfEnemy = map.locationOf(actor);
        for (Exit exit : locOfEnemy.getExits()){

            //check the locations around the enemy and search for the player
            Location pointImLookingAt = exit.getDestination();


            //check if the location has an actor
            if (pointImLookingAt.containsAnActor()){

                Actor target = pointImLookingAt.getActor();

                // Checks if the potential target is in one of the same families
                boolean partOfFamily = false;
                for (Family targetFamily : target.findCapabilitiesByType(Family.class))  {
                    for (Family actorFamily: actor.findCapabilitiesByType(Family.class)) {
                        if (targetFamily == actorFamily) {
                            partOfFamily = true;
                            break;
                        }
                    }
                }
                //check that the actor is the player or not part of the family
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY) || !(partOfFamily)){

                    //if enemy has no weapons attack using intrinsic weapon
                    //else use the first weapon is the inventory
                    if(actor.getWeaponInventory().isEmpty()){
                        return new AttackAction(target,exit.getName());
                    } else {
                        //see if the enemy is eligible to perform a special attack
                        if (actor.getWeaponInventory().get(0).getSkill(actor) != null && RandomNumberGenerator.getRandomInt(0,100) <= 50){
                            //roll for mood
                            actor.getWeaponInventory().get(0).getSkill(actor).execute(actor, map);
                        }else {
                            //if no skill or mood check fails settle for a normal attack (blegh)
                            return new AttackAction(target, exit.getName(), actor.getWeaponInventory().get(0));
                        }
                    }
                }
            }
        }
        //if none of the exits have an enemy just return null
        return null;

    }
}
