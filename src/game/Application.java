package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;
import game.actors.enemies.LoneWolf;
import game.actors.Player;
import game.actors.archetypes.Archetype;
import game.grounds.*;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new GustOfWind(), new Graveyard(), new PuddleOfWater(), new SiteOfLostGrace());

		List<String> map = Arrays.asList(
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~" ,
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~" ,
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~" ,
				"..................................__#....................~~~~~~~~~~~~~~~~~~" ,
				"......................._____........#.....................~~~~~~~~~~~~~~~~~" ,
				"......................#............_#......................~~~~~~~~~~~~~~~~" ,
				"......................#...........###......................................" ,
				"..........................................................................." ,
				"..........................................................................." ,
				"~~~~~~~~~~~.......................###___###................................" ,
				"~~~~~~~~~~~~......................________#....nnnn........................" ,
				"~~~~~~~~~~~~~U....................#________................................" ,
				"~~~~~~~~~~~~......................#___U___#....nnnn........................" ,
				"~~~~~~~~~~~.......................###___###................................" ,
				"~~~~~~~~~~..........................#___#.................................." ,
				"..........................................................................." ,
				"..........................................................................." ,
				"..........................................................................." ,
				"..####__##...........................................&&&......######..##..." ,
				"..#.....__...........................................&&&......#....____...." ,
				"..#___..............&&&..............................&&&........__.....#..." ,
				"..####__###.........&&&......................................._.....__.#..." ,
				"....................&&&.......................................###..__###..." ,
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		gameMap.at(37, 10).addActor(new MerchantKale());


		// Get archetype choice and inject into player
		Archetype playerArchetype = ArchetypePicker.getArchetypeChoice();
		Player player = new Player("Tarnished", '@', playerArchetype);

		world.addPlayer(player, gameMap.at(37, 11));

		world.run();
	}
}
