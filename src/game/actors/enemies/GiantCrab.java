package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.items.weapons.Slam;

public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("Giant Crab", 'c', 407);
        this.behaviours.put(999, new WanderBehaviour());
        this.addWeaponToInventory(new Slam());
        this.addCapability(EnemyFamily.Crustaceans);
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

}
