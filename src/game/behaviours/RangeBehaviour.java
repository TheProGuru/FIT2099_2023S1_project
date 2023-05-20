package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.combat.AttackAction;
import game.actors.enemies.Family;

import java.util.ArrayList;

/**
 * A class that prompts an enemy with an attack action if it sees a hostile actor in its surrounding
 * Created by:
 * @author Salar Ghadrigolestani
 * Modified by: Salar Ghadrigolestani
 *
 */
public class RangeBehaviour implements Behaviour {

    /**
     * the range that the behaviour checks for actors
     */
    private final int range;

    /**
     * Sets the range that the behaviour checks for actors
     *
     * @param range the range that the behaviour checks for actors
     */
    public RangeBehaviour(int range){
        this.range = range;
    }

    /**
     * looks for non-friendly actors in the holder's weapon range(excluding the actors immediate surroundings)
     *
     * @param currentLocation the current location of the Actor acting
     * @param map the GameMap containing the Actor
     * @return the list of non-friendly actors present in the range(excluding the actors immediate surroundings
     * and friendly actors)
     */
    public ArrayList<Actor> checkSurrounding(Location currentLocation, GameMap map) {

        ArrayList<Actor> targets = new ArrayList<>();
        int checkingRange = range;
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
     * Checks the actors surrounding and if the target is not part of the actors family it returns an attack action
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an attack action if valid or null if not
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location currentLocation = map.locationOf(actor);
        ArrayList<Actor> targets = checkSurrounding(currentLocation, currentLocation.map());
        if (!targets.isEmpty()){
            for(Actor target: targets){
                boolean partOfFamily = false;
                for (Family targetFamily : target.findCapabilitiesByType(Family.class))  {
                    for (Family actorFamily: actor.findCapabilitiesByType(Family.class)) {
                        if (targetFamily == actorFamily) {
                            partOfFamily = true;
                            break;
                        }
                    }
                }
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY) || !(partOfFamily)){
                    return new AttackAction(target, "distance", actor.getWeaponInventory().get(0));
                }
            }
        }
        return null;
    }
}