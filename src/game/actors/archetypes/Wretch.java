package game.actors.archetypes;

import game.items.weapons.Club;

/**
 * Defines the Wretch archetype
 *
 * @author William Bata-Kindermann
 * @see Club
 */
public class Wretch extends Archetype {

    /**
     * Constructor
     */
    public Wretch() {
        super(new Club(), 414);
    }
}
