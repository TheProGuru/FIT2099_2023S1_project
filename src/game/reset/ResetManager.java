package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

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
}
