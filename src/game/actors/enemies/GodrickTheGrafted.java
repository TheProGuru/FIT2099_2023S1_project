package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.behaviours.FollowBehaviour;
import game.items.RemembranceOfTheGrafted;
import game.items.weapons.AxeOfGodrick;
import game.items.weapons.GraftedDragon;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class GodrickTheGrafted extends Enemy{

    public GodrickTheGrafted() {
        super("Godrick the Grafted",'y',6080);
        this.addCapability(Family.CASTLE_DWELLER);
        this.addCapability(Family.BOSS);
        this.addWeaponToInventory(new AxeOfGodrick());
        this.addItemToInventory(new RemembranceOfTheGrafted());
        //remove old wander behaviour the boss should wait in the center of the room till the player arrives
        this.behaviours.remove(999);

    }
    /**
     * At each turn, select a valid action to perform.
     * Godrick as a boss needs to be able to swap weapons so his playTurn must be slightly different
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */

    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        //create a sorted list of keys so that we can use the behaviours in order
        ArrayList<Integer> behaviourKeys= new ArrayList<>(this.behaviours.keySet());
        Collections.sort(behaviourKeys);

        //check if under half hp if so swap weapons
        if(this.hitPoints < 3040){
            //pull out the axe of godrick
            this.removeWeaponFromInventory(this.getWeaponInventory().get(0));
            //add the all new grafted dragon
            this.addWeaponToInventory(new GraftedDragon());
        }
        else if (this.getWeaponInventory().get(0).getDisplayChar() == 'T') {
            //if the health is more than half and you have a grafted dragon swap it back to the axe
            this.removeWeaponFromInventory(this.getWeaponInventory().get(0));
            this.addWeaponToInventory(new AxeOfGodrick());
        }

        /*
        * Salar's code
        *
        * check if hostiles are within range of 4 and aggro on them
        */
        Location currentLocation = map.locationOf(this);
        int checkingRange = 4;
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
                            if(map.at(x, y).containsAnActor() && map.at(x, y).getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                                behaviours.put(10, new FollowBehaviour(map.at(x, y).getActor()));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < behaviourKeys.size(); i++) {
            Action action = this.behaviours.get(behaviourKeys.get(i)).getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public int generateRunes() {
        return 20000;
    }
    @Override
    public void reset(GameMap map) {
        this.hitPoints = this.maxHitPoints;
    }

}
