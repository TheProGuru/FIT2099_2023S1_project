package game.items.weapons;

import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Salar Ghadrigolestani
 *
 */
public class Club extends WeaponItem {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        TradeManager tm = TradeManager.getInstance();
        tm.registerWeapon(this);
    }
}
