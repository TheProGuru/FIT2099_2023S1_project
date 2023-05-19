package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.utils.RandomNumberGenerator;

/**
 * Mimic enemy
 *
 * Holds an item that is dropped on death.
 * If item is a weapon, it will not use it.
 *
 * @see game.actors.stationary.FakeChest
 */
public class Mimic extends Enemy {

    /**
     * Constructor
     * @param item Item held
     */
    public Mimic(Item item) {
        super("Mimic", 'M', 280);
        this.addItemToInventory(item);
        this.behaviours.clear();
        this.behaviours.put(5, new AttackBehaviour());
    }

    /**
     * Constructor with actor to follow
     * @param item Item held
     * @param follow Actor to follow
     */
    public Mimic(Item item, Actor follow) {
        super("Mimic", 'M', 280);
        this.addItemToInventory(item);
        this.behaviours.clear();
        this.behaviours.put(5, new AttackBehaviour());
        this.behaviours.put(10, new FollowBehaviour(follow));
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10000, "chomps", 10);
    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(1337, 1337);
    }
}
