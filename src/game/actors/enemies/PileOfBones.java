package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.AttackAction;
import game.actions.ReplaceAction;
import game.behaviours.Behaviour;
import game.items.weapons.Grossmesser;

import java.util.ArrayList;

public class PileOfBones extends Enemy{

    private int turnCount = 3;
    public PileOfBones(){
        super("Pile Of Bones", 'x',1);
        // It carries a grossmesser so it can drop it upon death
        this.addWeaponToInventory(new Grossmesser());

    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     *
     * The Pile of bones simply does nothing every turn while counting how many turns it has gone through
     * thus it overrides the Enemy parent method
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //check if out of turns
        if (turnCount == 0){
            //if out of turns despawn the pile of bones and summon a HSS
            return new ReplaceAction(new HeavySkeletalSwordsman());
        } else {
            turnCount = turnCount - 1;
            return new DoNothingAction();
        }
    }

    /**
     * Pile of Bones cannot attack the enemy and can only be attacked
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attack the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
        }
        return actions;
    }
}
