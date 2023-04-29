package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.actors.archetypes.Archetype;
import game.items.FlaskOfCrimsonTears;
import game.items.weapons.Club;
import game.reset.Resettable;
import game.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private Archetype archetype;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param archetype   Player's archetype
	 */
	public Player(String name, char displayChar, Archetype archetype) {
		super(name, displayChar, archetype.getStartingHitpoints());
		this.archetype = archetype;
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(archetype.getStartingWeapon());
		this.addItemToInventory(new FlaskOfCrimsonTears());
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		display.println("Current Hitpoints: " +this.printHp());
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void reset() {}
}
