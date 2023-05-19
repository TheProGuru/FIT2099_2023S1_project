package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

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

        this.addCapability(Family.DOGS);
    }



    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(55, 1470);
    }
}
