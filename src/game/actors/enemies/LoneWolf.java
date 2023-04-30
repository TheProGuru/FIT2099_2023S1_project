package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Ibrahem Abdul Khalik
 */
public class LoneWolf extends Enemy {
    //private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.behaviours.put(999, new WanderBehaviour());
        this.addCapability(EnemyFamily.Dogs);
    }



    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
