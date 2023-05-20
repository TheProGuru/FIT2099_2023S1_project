package game.items.runes;

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
     *
     */
    public void addRunes(int runes){
        this.runes += runes;
    }

    /**
     * subtracts runes or tells you don't have enough balance
     *
     * @param runes Runes that are to be removed from the wallet
     *
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
     * meaning you cant spend money you don't have
     *
     * @param runes Runes that are to be removed from the wallet
     * @return validity   that specifies weather the subtraction is greater or equal to 0
     */
    public boolean isValidSubtraction(int runes){
        return this.runes - runes >= 0;
    }

    public void dropRunePile(Location location){
        if (this.runes > 0) {
            int runesToDrop = this.runes;
            this.subtractRunes(this.runes);
            location.addItem(new RunePile(runesToDrop, location));
        }
    }
    public int getBalance(){return this.runes;}

}
