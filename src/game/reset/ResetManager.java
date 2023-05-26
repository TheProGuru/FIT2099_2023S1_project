package game.reset;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Player;
import game.items.runes.RuneManager;
import game.utils.FancyMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables and handles the game reset
 *
 * Created by: Adrian Kristanto
 *
 * @see Resettable
 *
 */
public class ResetManager {
    /**
     * List of all registered resettables
     */
    private final List<Resettable> resettables;
    /**
     * The singular instance of ResetManager to call statically
     */
    private static ResetManager instance;

    /**
     * The player
     */
    private Player player;

    /**
     * Location of last rest
     */
    private Location lastRest;


    /**
     * Constructor (private)
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Returns the singular instance of ResetManager
     * @return The singular instance of ResetManager
     */
    public static ResetManager getInstance(){
        // If ResetManager hasn't yet been instantiated
        if (ResetManager.instance == null){
            ResetManager.instance = new ResetManager();
        }
        return ResetManager.instance;
    }

    /**
     * Runs a standard game reset
     * @param map the game map
     */
    public void runReset(GameMap map) {

        Display display = new Display();
        display.println("");
        // prints "YOU DIED"
        for (String line : FancyMessage.YOU_DIED.split("\n")) {
            display.println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Reset all resettables
        for (Resettable anInstance : this.resettables){
            anInstance.reset(map);
        }


        // Drops all the player's runes at the location of death
        RuneManager runeM = RuneManager.getInstance();
        int runes = runeM.getBalance();
        runeM.dropRunePile(player.getLastLocation());


        // Moves the player to last site of lost grace or if null just removes the player
        map.removeActor(player);
        if (lastRest != null) {
            display.println(player + " spawns at the last Site of Lost Grace with " + runes + " less runes.");
            map.addActor(player, lastRest);
        }
    }


    /**
     * Runs a "Rest" reset
     * @param map The Game Map
     */
    public void runRest(GameMap map) {
        for (Resettable anInstance : this.resettables){
            if(anInstance.resetOnRest()){
                anInstance.reset(map);
            }

        }
    }

    /**
     * Register an instance of resettable with the ResetManager
     * @param resettable A resettable
     */
    public void registerResettable(Resettable resettable) {this.resettables.add(resettable);}

    /**
     * Removes an instance of resettable from ResetManager records
     * @param resettable A resettable
     */
    public void removeResettable(Resettable resettable) {this.resettables.remove(resettable);}

    /**
     * Gets the location of the last rest
     * @return Location of last rest
     */
    public Location getLastRest() {
        return lastRest;
    }

    /**
     * Sets the Location of last rest
     * @param location Location to update last rest to
     */
    public void setLastRest(Location location) {
        this.lastRest = location;
    }

    /**
     * Registers the player with ResetManager
     * @param player the player
     */
    public void registerPlayer(Player player) {
        this.player = player;
    }

}
