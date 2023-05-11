package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.weapons.Slam;
import game.utils.RandomNumberGenerator;

public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("Giant Crab", 'c', 407);
        this.addWeaponToInventory(new Slam());
        this.addCapability(EnemyFamily.CRUSTACEANS);
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(318,4961);
    }
}
