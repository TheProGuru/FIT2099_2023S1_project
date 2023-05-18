package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ActivateAction;
import game.actions.RestAction;
import game.utils.FancyMessage;


/**
 * Site of Lost Grace
 * Allows the player to rest
 *
 * Must be added to the map manually
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see Ground
 */
public class SiteOfLostGrace extends Ground implements Activatable {

    /**
     * Name of the instance
     */
    private final String name;

    /**
     * Whether the instance has been discovered by the player
     */
    private boolean discovered = false;

    /**
     * Constructor
     */
    public SiteOfLostGrace(String tileName) {
        super('U');
        this.name = tileName;
    }

    /**
     * Gets the allowable actions for the Site Of Lost Grace
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList al =  new ActionList();

        if (this.discovered) {
            al.add(new RestAction(location));
        } else {
            al.add(new ActivateAction(this));
        }

        return al;
    }

    /**
     * Gets the name of the instance
     * @return Name as String
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Prints a fancy message when triggered that indicates that the site was discovered.
     */
    private void printDiscoveredMessage() {
        for (String line : FancyMessage.LOST_GRACE_DISCOVERED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public String activate() {
        this.discovered = true;
        printDiscoveredMessage();
        return this + " has been activated and can now be used.";
    }
}
