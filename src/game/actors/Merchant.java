package game.actors;

import game.actions.trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;


public abstract class Merchant extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the merchant in the UI
     * @param displayChar Character to represent the merchant in the UI
     * @param hitPoints maximum hitpoints of the merchant
     */
    public Merchant(String name, char displayChar, int hitPoints){
        super(name,displayChar,hitPoints);
        this.addCapability(Status.FRIENDLY);
    }

    /**
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return a DoNothingAction
     */

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Calls upon the TradeManager and checks if any valid trades are available
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        TradeManager tm = TradeManager.getInstance();
        return tm.checkForTrades(this);
    }
}