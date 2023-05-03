package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class RuneManager {
    private int runes;
    private static RuneManager instance;

    private RuneManager() {this.runes = 0;}

    public static RuneManager getInstance(){
        if (RuneManager.instance == null){
            RuneManager.instance = new RuneManager();
        }
        return RuneManager.instance;
    }


    /**
     * Adds runes to wallet
     *
     * @param runes Runes that are to be added into the wallet
     * @return Balance   returns the balance after adding the runes
     */
    public void addRunes(int runes){
        this.runes += runes;
    }

    /**
     * subtracts runes or tells you dont have enough balance
     *
     * @param runes Runes that are to be removed from the wallet
     * @return balance   returns the balance after adding the runes
     */
    public void subtractRunes(int runes){
        if (isValidSubtraction(runes)){
            this.runes -= runes;
        }else{
            throw new IllegalArgumentException("Subtracting more runs than the player has");
        }
    }

    /**
     * checks if you can subtract runes
     * will return a false if the subtraction goes under 0
     * meaning you cant spend money you dont have
     *
     * @param runes Runes that are to be removed from the wallet
     * @return validity   that specifies weither the subtraction is greater or equal to 0
     */
    public boolean isValidSubtraction(int runes){
        if (this.runes - runes < 0){
            return false;
        } else {
            return true;
        }
    }

    public void dropRunePile(Location location, int runes){
        if (this.runes > 0) {
            int runesToDrop = this.runes;
            this.subtractRunes(this.runes);
            location.addItem(new RunePile(runesToDrop, location));
        }
    }
    public int getBalance(){return this.runes;}

}
