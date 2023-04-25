package game.items.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A dagger that can be used to attack the enemy.
 * It deals 75 damage with 70% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */

public class GreatKnife extends WeaponItem {

    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "Stabs", 70);
    }
}
