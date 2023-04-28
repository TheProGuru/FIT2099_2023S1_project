package game.actors.archetypes;

import game.items.weapons.Club;

/**
 * Defines the Samurai archetype
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 */
public class Samurai extends Archetype {

    /**
     * Constructor
     */
    public Samurai() {
        super(new Club(), 455); // Change to katana
    }
}
