package game.actors.archetypes;

import game.items.weapons.Uchigatana;

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
        super(new Uchigatana(), 455);
    }
}
