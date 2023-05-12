package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.archetypes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Archetype Picker Class
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Archetype
 */
public class ArchetypePicker {

    /**
     * Asks the player which Archetype they would like to play.
     * @return An instance of the Archetype selected
     */
    public static Archetype getArchetypeChoice() {

        String parsedArchetype;
        Display display = new Display();
        while (true) {
            try {
                display.println("\nBandit: 1\n" +
                        "Samurai: 2\n" +
                        "Wretch: 3\n" +
                        "Astrologer: 4\n"+
                        "Pick your Archetype:");
                Scanner scanner = new Scanner(System.in);
                parsedArchetype = scanner.nextLine();

                return switch (parsedArchetype) {
                    case "1" -> new Bandit();
                    case "2" -> new Samurai();
                    case "3" -> new Wretch();
                    case "4" -> new Astrologer();
                    default -> throw new InputMismatchException("Class not valid");
                };
            } catch(InputMismatchException e) {
                display.println("\nPlease enter a valid class\n");
            }
        }

    }

}
