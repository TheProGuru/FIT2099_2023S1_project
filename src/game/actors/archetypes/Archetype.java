package game.actors.archetypes;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Abstract Archetype class
 * Defines starting conditions and items for actors that have it
 *
 * @author William Bata-Kindermann
 * @see edu.monash.fit2099.engine.actors.Actor
 * @see WeaponItem
 */
public abstract class Archetype {

    /**
     * Starting weapon
     */
    private final WeaponItem startWeapon;

    /**
     * Starting Hitpoints
     */
    private final int startHitpoints;

    /**
     * Constructor
     * @param startWeapon The Weapon to start with
     * @param startHitpoints The amount of hitpoints to start with
     */
    public Archetype(WeaponItem startWeapon, int startHitpoints) {
        this.startWeapon = startWeapon;
        this.startHitpoints = startHitpoints;
    }

    /**
     * Returns the starting weapon for the archetype
     * @return starting WeaponItem
     */
    public WeaponItem getStartingWeapon() {
        return startWeapon;
    }

    /**
     * Returns the starting hitpoints for the archetype
     * @return starting hp as int
     */
    public int getStartingHitpoints() {
        return startHitpoints;
    }
}
