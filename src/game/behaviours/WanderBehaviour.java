package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DespawnAction;
import game.utils.RandomNumberGenerator;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Ibrahem Abdul Khalik
 */
public class WanderBehaviour implements Behaviour {
	
	private final Random random = new Random();
	private final int DESPAWN_RATE;

	// constructor that sets default spawn rate
	public WanderBehaviour(){DESPAWN_RATE = 10;}
	// overloaded constructor that allows a different despawn rate
	public WanderBehaviour(int despawnRate){this.DESPAWN_RATE = despawnRate;}
	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (RandomNumberGenerator.getRandomInt(1,100) <= DESPAWN_RATE){
			return new DespawnAction();
		}

		ArrayList<Action> actions = new ArrayList<>();

		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null;
		}

	}
}
