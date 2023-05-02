package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Player;
import game.items.runes.RuneManager;
import game.utils.FancyMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private final List<Resettable> resettables;
    private static ResetManager instance;

    private Player player;
    private Location lastRest;


    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    public static ResetManager getInstance(){
        if (ResetManager.instance == null){
            ResetManager.instance = new ResetManager();
        }
        return ResetManager.instance;
    }

    public void runReset(GameMap map) {
        for (Resettable anInstance : this.resettables){
            anInstance.reset(map);
        }
        RuneManager.getInstance().dropRunePile(player.getLastLocation());

        Display display = new Display();
        display.println("");
        // YOU DIED
        for (String line : FancyMessage.YOU_DIED.split("\n")) {
            display.println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        map.removeActor(player);
        if (lastRest != null) {
            display.println(player + " spawns at the last Site of Lost Grace");
            map.addActor(player, lastRest);
        }
    }

    public void runRest(GameMap map) {
        for (Resettable anInstance : this.resettables){
            if(anInstance.resetOnRest()){
                anInstance.reset(map);
            }

        }
    }

    public void registerResettable(Resettable resettable) {this.resettables.add(resettable);}

    public void removeResettable(Resettable resettable) {this.resettables.remove(resettable);}

    public Location getLastRest() {
        return lastRest;
    }

    public void setLastRest(Location location) {
        this.lastRest = location;
    }

    public void registerPlayer(Player player) {
        this.player = player;
    }

}
