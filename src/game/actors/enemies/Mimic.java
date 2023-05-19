package game.actors.enemies;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RandomNumberGenerator;

public class Mimic extends Enemy {

    public Mimic(Item item) {
        super("Mimic", 'M', 280);
        this.addItemToInventory(item);
    }

    public Mimic(WeaponItem item) {
        super("Mimic", 'M', 280);
        this.addWeaponToInventory(item);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10000, "chomps", 10);
    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(55, 1470);
    }
}
