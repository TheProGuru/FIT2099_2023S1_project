package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.List;

public class AOEAction extends Action {

    private Actor wielder;

    private Weapon weapon;


    /**
     * Constructor.
     *
     * @param wielder the one performing the attack
     * @param weapon the weapon used for the attack
     */
    public AOEAction(Actor wielder, WeaponItem weapon){
        this.wielder = wielder;
        this.weapon = weapon;
    }
    /**
     * Constructor used for intrinsic weapons.
     *
     * @param wielder the one performing the attack
     */
    public AOEAction(Actor wielder){
        this.wielder = wielder;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(wielder).getExits();
        String result = actor + " performs an AOE Attack.";
        for (Exit exit : exits){
            Location location = exit.getDestination();
            if(location.containsAnActor()){
                if (this.weapon == null){
                    result += new AttackAction( location.getActor(),exit.getName()).execute(actor,map);
                }else{
                    result += new AttackAction( location.getActor(),exit.getName(),this.weapon).execute(actor,map);
                }
            }

        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
