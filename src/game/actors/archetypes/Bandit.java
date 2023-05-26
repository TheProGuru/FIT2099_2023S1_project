package game.actors.archetypes;

import game.items.weapons.GreatKnife;

/**
 * Defines the Bandit archetype
 *
 * @author William Bata-Kindermann
 * @see GreatKnife
 */
public class Bandit extends Archetype {

    /**
     * Constructor
     */
    public Bandit() {
        super(new GreatKnife(), 414);
    }

}
