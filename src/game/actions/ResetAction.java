package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.reset.ResetManager;

public class ResetAction extends Action {
    @Override
    public String execute(Actor player, GameMap map) {
        ResetManager.getInstance().runReset(map);
        return "The game has been reset";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
