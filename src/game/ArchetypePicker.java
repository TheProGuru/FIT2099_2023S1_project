package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.archetypes.*;
import game.utils.RandomNumberGenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Archetype Picker Class
 * Created by William-Bata-Kindermann
 * Last Modified By Ibrahem Abdul Khalik
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

        // Until a valid archetype is picked
        while (true) {
            try {
                display.println("""

                        1: Bandit
                        2: Samurai
                        3: Wretch
                        4: Astrologer
                        5: Random
                        Pick your Archetype:""");
                Scanner scanner = new Scanner(System.in);
                parsedArchetype = scanner.nextLine();

                return switch (parsedArchetype) {
                    case "1" -> new Bandit();
                    case "2" -> new Samurai();
                    case "3" -> new Wretch();
                    case "4" -> new Astrologer();
                    case "5" -> getRandomArchetype();
                    default -> throw new InputMismatchException("Class not valid");
                };
            } catch(InputMismatchException e) {
                display.println("\nPlease enter a valid class\n");
            }
        }

    }

    public static Archetype getRandomArchetype() {

        switch (RandomNumberGenerator.getRandomInt(1,4)) {
            case 1: return new Bandit();
            case 2: return new Samurai();
            case 3: return new Wretch();
            case 4: return new Astrologer();
            default: return null;
        }
    }
}
