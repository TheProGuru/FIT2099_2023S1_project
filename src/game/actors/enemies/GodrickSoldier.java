package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Enemy {

    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        //this.addWeaponToInventory(new HeavyCrossbow());
        this.addCapability(EnemyFamily.CASTLE_DWELLER);
    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(38, 70);
    }

}
