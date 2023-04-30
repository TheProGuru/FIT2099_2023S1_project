package game.actors.enemies;

import game.behaviours.WanderBehaviour;
import game.items.weapons.Grossmesser;


public class HeavySkeletalSwordsman extends Enemy{
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());
        //add the Grossmesser to weapon inventory
        this.addWeaponToInventory(new Grossmesser());
        this.addCapability(EnemyFamily.Skeletons);
    }




}
