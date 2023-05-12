package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.archetypes.Archetype;
import game.world.WorldConstructor;
import game.utils.FancyMessage;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());


		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}


		// Get archetype choice and inject into player
		Archetype playerArchetype = ArchetypePicker.getArchetypeChoice();
		Player player = new Player("Tarnished", '@', playerArchetype);

		WorldConstructor.generateMaps(world, player);
		world.run();
	}
}
