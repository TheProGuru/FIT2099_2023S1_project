package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.combat.AttackAction;
import game.actors.enemies.EnemyFamily;

import java.util.ArrayList;


public class RangeBehaviour  implements Behaviour {

    public ArrayList<Actor> checkSurrounding(Location currentLocation, GameMap map) {

        ArrayList<Actor> targets = new ArrayList<>();
        int currentX = currentLocation.x();
        int currentY = currentLocation.y();
        int xHighBound = map.getXRange().max();
        int yHighBound = map.getYRange().max();


        for (int x = currentX - 2; x <= currentX + 2; x++) {
            if (x >= 0 && x <= xHighBound) {
                for (int y = currentY - 2; y <= currentY + 2; y++) {
                    if (y >= 0 && y <= yHighBound) {
                        if (map.at(x, y).containsAnActor()) {
                            targets.add(map.at(x, y).getActor());
                        }
                    }
                }
            }
        }
        return targets;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location currentLocation = map.locationOf(actor);
        ArrayList<Actor> targets = checkSurrounding(currentLocation, currentLocation.map());
        if (!targets.isEmpty()){
            for(Actor target: targets){
                boolean partOfFamily = false;
                for (EnemyFamily targetFamily : target.findCapabilitiesByType(EnemyFamily.class))  {
                    for (EnemyFamily actorFamily: actor.findCapabilitiesByType(EnemyFamily.class)) {
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