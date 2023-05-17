package game.items.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

public class AxeofGodrick extends WeaponItem {
    public AxeofGodrick() {
        super("Axe of Godrick", 'T', 142 , "Slits", 84);
    }

    public void removeAreaAction(){
        for(int i = 0; i < this.getAllowableActions().size(); i++){
            if(getAllowableActions().get(i).getClass().equals(AreaAttackAction.class)){
                this.removeAction(getAllowableActions().get(i));
                i --;
            }
        }
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        removeAreaAction();
        boolean isActorAround = false;
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                isActorAround = true;
            }
        }
        if(isActorAround){
            this.addAction(getSkill(actor));
        }
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
