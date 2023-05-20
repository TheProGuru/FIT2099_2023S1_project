package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.combat.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.runes.RuneGenerator;
import game.reset.ResetManager;
import game.reset.Resettable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Enemy extends Actor implements Resettable, RuneGenerator {
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    Enemy(String name, char displayChar,int hitPoints){
        super(name, displayChar, hitPoints);
        ResetManager.getInstance().registerResettable(this);
        this.behaviours.put(5, new AttackBehaviour());
        this.behaviours.put(999, new WanderBehaviour());
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
                //check if actor is a player
                if (target.hasCapability(Status.IS_PLAYER)){
                    //if actor is a player create a follow behaviour with hash key 10
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
    /**
     * The enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions   a List of actions the player can do
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){

            //will use intrinsic weapon 
            actions.add(new AttackAction(this, direction));

            //add an option for every weapon the player owns
            //jack of all trades, master of none
            for (WeaponItem weapon : otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weapon));
            }
        }
        return actions;
    }

    @Override
    public void reset(GameMap map) {
        map.removeActor(this);
    }
}
