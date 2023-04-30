package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.SiteOfLostGrace;
import game.reset.ResetManager;

public class RestAction extends Action {

    private Location location;

    public RestAction(Location location) {
        super();
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager RM = ResetManager.getInstance();
        RM.setLastRest(map.locationOf(actor));
        RM.runRest(map);
        return actor + " rests at " + location.getGround().toString();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests";
    }

}
