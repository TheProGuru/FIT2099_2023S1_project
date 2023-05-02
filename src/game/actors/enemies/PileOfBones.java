package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.ReplaceAction;
import game.items.weapons.Grossmesser;

public class PileOfBones extends Enemy {

    private int turnCount = 3;

    public PileOfBones() {
        super("Pile Of Bones", 'x', 1);
        // It carries a grossmesser so it can drop it upon death
        this.addWeaponToInventory(new Grossmesser());
        this.addCapability(EnemyFamily.Skeletons);
        behaviours.clear(); // Removes all default enemy behaviour
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     * <p>
     * The Pile of bones simply does nothing every turn while counting how many turns it has gone through
     * thus it overrides the Enemy parent method
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //check if out of turns
        if (turnCount == 0) {
            //if out of turns despawn the pile of bones and summon a HSS
            return new ReplaceAction(new HeavySkeletalSwordsman());
        } else {
            turnCount = turnCount - 1;
            return new DoNothingAction();
        }
    }
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(0, "chatters", 100);
    }
}
