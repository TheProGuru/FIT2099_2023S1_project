package game.actors.archetypes;

import game.items.weapons.Uchigatana;

/**
 * Defines the Samurai archetype
 *
 * @author William Bata-Kindermann
 * @see Uchigatana
 */
public class Samurai extends Archetype {

    /**
     * Constructor
     */
    public Samurai() {
        super(new Uchigatana(), 455);
    }
}
