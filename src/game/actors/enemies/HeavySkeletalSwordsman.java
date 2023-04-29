package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.actions.AttackAction;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.weapons.Grossmesser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HeavySkeletalSwordsman extends Enemy{
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());
        //add the Grossmesser to weapon inventory
        this.addWeaponToInventory(new Grossmesser());
    }


    /**
     * The heavy skeletal swordsman can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
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
            if (otherActor.getWeaponInventory().isEmpty()) {
                //will use instrinsic weapon if
                actions.add(new AttackAction(this, direction));
                // HINT 1: The AttackAction above allows you to attack the enemy with your intrinsic weapon.
                // HINT 1: How would you attack the enemy with a weapon?
            } else {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(0)));
            }
        }
        return actions;
    }

}
