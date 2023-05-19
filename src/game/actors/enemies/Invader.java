package game.actors.enemies;

import game.actors.archetypes.Archetype;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;

/**
 *
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class Invader extends Enemy{

    Archetype archetype;
    public Invader(Archetype archetype) {
        super("Invader", 'ඞ', archetype.getStartingHitpoints());
        this.archetype = archetype;
        this.addWeaponToInventory(archetype.getStartingWeapon());
        this.addCapability(Family.ALIEN);
        //remove old wander behaviour and add new one with no despawn rate
        this.behaviours.remove(999);
        this.behaviours.put(999, new WanderBehaviour(0));
    }

    @Override
    public int generateRunes(){
        return RandomNumberGenerator.getRandomInt(1358, 5578);
    }

    @Override
    public boolean resetOnRest() {
        return false;
    }
}
