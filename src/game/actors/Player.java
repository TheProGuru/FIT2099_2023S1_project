package game.actors;

import Trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.archetypes.Archetype;
import game.items.FlaskOfCrimsonTears;
import game.items.runes.RuneManager;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.Status;

import java.util.ArrayList;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by: Adrian Kristanto
 * Modified by: The Team
 *
 */
public class Player extends Actor implements Resettable {
	/**
	 * The location of the player last turn
	 */
	private Location lastLocation;

	/**
	 * The menu
	 */
	private final Menu menu = new Menu();

	/**
	 * The player's Archetype
	 */
	private Archetype archetype;

	/**
	 * All the Buyables items that the player possesses
	 */
	private ArrayList<Action> actionList = new ArrayList<>();

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
		this.addCapability(Status.IS_PLAYER);
		this.addWeaponToInventory(archetype.getStartingWeapon());
		this.addItemToInventory(new FlaskOfCrimsonTears());
		ResetManager rm = ResetManager.getInstance();
		rm.registerResettable(this);
		rm.registerPlayer(this);
		TradeManager tm = TradeManager.getInstance();
		tm.registerPlayer(this);
	}
	/**
	 * Handles the player's turn
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return The action to play for the turn
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		this.lastLocation = map.locationOf(this);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		display.println(this+"'s hitpoints: " + this.printHp());
		display.println(this+"'s balance: " + RuneManager.getInstance().getBalance());

		for (Action tradeAction: actionList){
			actions.add(tradeAction);
		}
		// return/print the console menu
		Action showMenu = menu.showMenu(this, actions, display);
		actionList.clear();
		return showMenu;
	}

	public void setActionList(ArrayList<Action> actionList) {
		this.actionList = actionList;
	}

	/**
	 * Returns the Location of the player last turn
	 * @return Location the player was last turn
	 */
	public Location getLastLocation() {
		return this.lastLocation;
	}

	/**
	 * Resets the player
	 */
	@Override
	public void reset(GameMap map) {
		this.hitPoints = this.maxHitPoints;
	}
}
