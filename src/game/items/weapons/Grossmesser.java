package game.items.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A curved sword that can be used to attack the enemy.
 * It deals 115 damage with 85% hit rate
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem {

    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slashes", 85);
    }

}
