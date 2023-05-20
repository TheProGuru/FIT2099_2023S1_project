package game.actors.enemies;

import game.items.weapons.Grossmesser;

/**
 *
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class HeavySkeletalSwordsman extends Enemy{

    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        //add the Grossmesser to weapon inventory
        this.addWeaponToInventory(new Grossmesser());
        this.addCapability(Family.SKELETONS);
    }

    @Override
    public int generateRunes(){
        return 0;
    }
}
