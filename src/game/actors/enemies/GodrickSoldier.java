package game.actors.enemies;

import game.behaviours.RangeBehaviour;
import game.items.weapons.HeavyCrossbow;
import game.utils.RandomNumberGenerator;

public class GodrickSoldier extends Enemy {

    /**
     *
     * Created by:
     * @author Ibrahem Abdul Khalik
     * Modified by:
     *
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.addWeaponToInventory(new HeavyCrossbow());
        this.addCapability(Family.CASTLE_DWELLER);
        behaviours.put(4, new RangeBehaviour(2));

    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(38, 70);
    }
}
