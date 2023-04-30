package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction; // Remove this later
import game.items.FlaskOfCrimsonTears; // Remove this later


/**
 * Site of Lost Grace
 * Allows the player to rest
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 */
public class SiteOfLostGrace extends Ground {

    /**
     * Constructor
     */
    public SiteOfLostGrace() {
        super('U');
    }


    //THIS METHOD CURRENTLY HAS A VERY INAPPROPRIATE IMPLEMENTATION
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList al =  new ActionList();
        al.add(new ConsumeAction(new FlaskOfCrimsonTears()));
        return al;
    }

}
