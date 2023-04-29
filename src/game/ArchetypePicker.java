package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.archetypes.Archetype;
import game.actors.archetypes.Bandit;
import game.actors.archetypes.Samurai;
import game.actors.archetypes.Wretch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArchetypePicker {

    public static Archetype getArchetypeChoice() {

        String parsedArchetype;
        Display display = new Display();
        while (true) {
            try {
                display.println("\nBandit: 1\n" +
                        "Samurai: 2\n" +
                        "Wretch: 3\n" +
                        "Pick your Archetype:");
                Scanner scanner = new Scanner(System.in);
                parsedArchetype = scanner.nextLine();

                return switch (parsedArchetype) {
                    case "1" -> new Bandit();
                    case "2" -> new Samurai();
                    case "3" -> new Wretch();
                    default -> throw new InputMismatchException("Class not valid");
                };
            } catch(InputMismatchException e) {
                display.println("\nPlease enter a valid class\n");
            }
        }






    }



}
