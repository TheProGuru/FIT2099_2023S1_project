package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

/**
 * Dog enemy that's friendly to Godrick soldiers
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class Dog extends Enemy{
    public Dog() {
        super("Dog", 'a', 104);
        this.addCapability(Family.CASTLE_DWELLER);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }
    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(52, 1390);
    }

}
