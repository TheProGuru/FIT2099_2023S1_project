package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ArchetypePicker;
import game.actions.ActivateAction;
import game.actors.archetypes.Archetype;
import game.actors.Ally;
import game.actors.enemies.Invader;
import game.utils.RandomNumberGenerator;

/**
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class SummonSign extends Ground implements Activatable{

    Location location;

    /**
     * Constructor
     *
     */
    public SummonSign() {
        super('=');
    }

    @Override
    public void tick(Location location){
        this.location = location;
    }

    @Override
    public String activate() {
        Archetype archetype = ArchetypePicker.getRandomArchetype();
        int chance = RandomNumberGenerator.getRandomInt(0,100);
        if(chance <= 50){
            location.addActor(new Invader(archetype));
        }else{
            location.addActor(new Ally(archetype));
        }
        return "You summoned something from above the sky.";
    }
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList al =  new ActionList();
        al.add(new ActivateAction(this));
        return al;
    }
    @Override
    public String toString() {
        return "Summon Sign";
    }
}
