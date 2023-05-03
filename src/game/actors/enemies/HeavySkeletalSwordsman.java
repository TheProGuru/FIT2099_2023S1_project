package game.actors.enemies;

import game.items.weapons.Grossmesser;


public class HeavySkeletalSwordsman extends Enemy{
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        //add the Grossmesser to weapon inventory
        this.addWeaponToInventory(new Grossmesser());
        this.addCapability(EnemyFamily.Skeletons);
    }

    @Override
    public int generateRunes(){
        return 0;
    }



}
