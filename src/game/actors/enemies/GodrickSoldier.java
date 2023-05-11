package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.RangeBehaviour;
import game.items.weapons.HeavyCrossbow;
import game.utils.RandomNumberGenerator;
import org.w3c.dom.ranges.Range;

public class GodrickSoldier extends Enemy {

    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.addWeaponToInventory(new HeavyCrossbow());
        this.addCapability(EnemyFamily.CASTLE_DWELLER);
        behaviours.put(4, new RangeBehaviour());

    }


    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(38, 70);
    }

}
