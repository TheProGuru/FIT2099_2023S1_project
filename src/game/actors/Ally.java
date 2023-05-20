package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actors.archetypes.Archetype;
import game.actors.enemies.Family;
import game.behaviours.AlliedAttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.runes.RuneGenerator;
import game.reset.Resettable;

import java.util.*;

/**
 * Ally enemy that's actually friendly to the player
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class Ally extends Actor implements RuneGenerator, Resettable {

    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    Archetype archetype;
    public Ally(Archetype archetype) {
        super("Ally", 'A', archetype.getStartingHitpoints());
        this.archetype = archetype;
        this.addWeaponToInventory(archetype.getStartingWeapon());
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Family.HUMAN);
        this.behaviours.put(5, new AlliedAttackBehaviour());
        this.behaviours.put(999, new WanderBehaviour(0));
    }

    @Override
    public int generateRunes() {
        return 0;
    }

    @Override
    public void reset(GameMap map) {
        map.removeActor(this);
    }

    @Override
    public boolean resetOnRest() {
        return false;
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //create a sorted list of keys so that we can use the behaviours in order
        ArrayList<Integer> behaviourKeys= new ArrayList<>(this.behaviours.keySet());
        Collections.sort(behaviourKeys);

        //get a list of all exits around the enemy
        List<Exit> thisExits = map.locationOf(this).getExits();
        //loop through all exits
        for (Exit exit : thisExits){
            //extract the location of the exit
            Location destination = exit.getDestination();
            //check if location has an actor
            if (destination.containsAnActor()){
                //get actor from location
                Actor target = destination.getActor();
                //check if actor is a NOT a player
                if (!target.hasCapability(Status.IS_PLAYER)){
                    //if actor is NOT a player create a follow behaviour with hash key 10
                    //I decided follow has a later priority (attack being 5)
                    behaviours.put(10, new FollowBehaviour(target));
                }


            }
        }
        //if all exits don't have actors that are players no following is done

        for (int i = 0; i < behaviourKeys.size(); i++) {
            Action action = this.behaviours.get(behaviourKeys.get(i)).getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
