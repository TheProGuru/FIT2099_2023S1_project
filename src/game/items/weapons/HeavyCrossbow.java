package game.items.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.DropWeaponAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.*;
import game.actors.Player;

import java.util.ArrayList;

public class HeavyCrossbow extends WeaponItem implements Buyable {
    public HeavyCrossbow() {
        super("Heavy Crossbow", '}', 64, "Shoots", 57);
    }

    public void removeAttackAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(AttackAction.class)){
                this.removeAction(getAllowableActions().get(i));
                i --;
            }
        }
    }
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
                        if (!(((y == currentY - 1 || y == currentY + 1) && (x == currentX - 1 || x == currentX + 1))
                                || (x == currentX && y == currentY))){
                            if(map.at(x, y).containsAnActor()){
                                targets.add(map.at(x, y).getActor());
                            }
                        }
                    }
                }
            }
        }
        return targets;
    }
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
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable) {
            if (actor.hasCapability(Status.IS_PLAYER)){
                return getPlayerPickUpAction((Player) actor);
            }
            return new PickUpWeaponAction(this);
        }
        return null;
    }
    public PickUpAction getPlayerPickUpAction(Player player) {
        player.addValuable(this);
        return new PickUpWeaponAction(this);
    }
    @Override
    public DropAction getDropAction(Actor actor) {
        if (portable) {
            if (actor.hasCapability(Status.IS_PLAYER)){
                return new DropValuableAction(this);
            }
            return new DropWeaponAction(this);
        }
        return null;
    }

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public int getBuyPrice() {
        return 1500;
    }
}

