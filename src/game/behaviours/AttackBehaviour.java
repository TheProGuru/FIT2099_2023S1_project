package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.AttackAction;
import game.utils.RandomNumberGenerator;

public class AttackBehaviour implements Behaviour{

    //the target is the fella we slappin
    private final Actor target;


    /**
     * Constructor.
     *
     * @param subject the Actor to attack
     */
    public AttackBehaviour(Actor subject) {
        this.target = subject;
    }

    /**
     * Returns an AttackAction that targets the player if near
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        //make sure both actors exist
        if(!map.contains(this.target) || !map.contains(actor)) {
            return null;
        }

        Location locOfEnemy = map.locationOf(actor);
        for (Exit exit : locOfEnemy.getExits()){
            //check the locations around the enemy and search for the player
            Location pointImLookingAt = exit.getDestination();
            //check if the location has an actor
            if (pointImLookingAt.containsAnActor()){
                //check that the actor is the player
                if (pointImLookingAt.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                    //if enemy has no weapons attack using intrinsic weapon
                    //else use the first weapon is the inventory
                    if(actor.getWeaponInventory().isEmpty()){
                        return new AttackAction(this.target,exit.getName());
                    }else {
                        //see if the enemy is eligble to perform a special attack
                        if (actor.getWeaponInventory().get(0).getSkill(actor) != null){
                            //roll for mood
                            if (RandomNumberGenerator.getRandomInt(0,100) <= 10){
                                actor.getWeaponInventory().get(0).getSkill(actor).execute(actor, map);
                            }
                        }
                        //if no skill or mood check fails settle for a normal attack (blegh)
                        return new AttackAction(this.target,exit.getName(),actor.getWeaponInventory().get(0));
                    }
                }
            }
        }
        //if none of the exits have an enemy just return null
        return null;

    }
}
