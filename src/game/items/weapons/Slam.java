package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.combat.AreaAttackAction;

public class Slam extends WeaponItem {

    /**
     * Constructor
     */
    public Slam() {
        super("Slam", '?', 208, "Slams", 90);
        this.portable = false;
    }

    /**
     * returns an AOE attack in all directions
     *
     * @param holder weapon holder
     * @return a special Action that can be performed by this weapon (heal the player, etc.)
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
