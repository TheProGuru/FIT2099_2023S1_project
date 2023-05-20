package game.items.weapons;

import game.actions.combat.AttackAction;
import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;


import java.util.ArrayList;

public class HeavyCrossbow extends WeaponItem {

    /**
     * Constructor
     */
    public HeavyCrossbow() {
        super("Heavy Crossbow", '}', 64, "Shoots", 57);
        TradeManager tm = TradeManager.getInstance();
        tm.registerWeapon(this);
    }
    /**
     * removes any attack actions present in the weapons allowable actions
     */
    public void removeAttackAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(AttackAction.class)){
                this.removeAction(getAllowableActions().get(i));
                i --;
            }
        }
    }
    /**
     * looks for non-friendly actors in the weapon's range(excluding the actors immediate surroundings)
     *
     * @param currentLocation the current location of the Actor acting
     * @param map the GameMap containing the Actor
     * @return the list of non-friendly actors present in the range(excluding the actors immediate surroundings
     * and friendly actors)
     */
    public ArrayList<Actor> checkSurrounding(Location currentLocation, GameMap map){

        ArrayList<Actor> targets = new ArrayList<>();
        int checkingRange = 2;
        int currentX = currentLocation.x();
        int currentY = currentLocation.y();
        int xHighBound = map.getXRange().max();
        int yHighBound = map.getYRange().max();


        for(int x = currentX - checkingRange; x <= currentX + checkingRange; x ++){
            if (x >= 0 && x <= xHighBound){
                for (int y = currentY - checkingRange;y <= currentY + checkingRange; y++){
                    if (y >= 0 && y <= yHighBound){
                        if (!((y == currentY - 1 || y == currentY + 1 || y == currentY)
                                && (x == currentX - 1 || x == currentX + 1 || x == currentX))){
                            if(map.at(x, y).containsAnActor() && !map.at(x, y).getActor().hasCapability(Status.FRIENDLY)){
                                targets.add(map.at(x, y).getActor());
                            }
                        }
                    }
                }
            }
        }
        return targets;
    }
    /**
     * checks the surroundings of the current location and adds an attack action to the weapons allowable actions
     * for each non-friendly actor in its surroundings
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {

        removeAttackAction();
        ArrayList<Actor> targets = checkSurrounding(currentLocation, currentLocation.map());
        if (!targets.isEmpty()){
            for(Actor target: targets){
                this.addAction(new AttackAction(target, "distance", this));
            }
        }
    }
}

