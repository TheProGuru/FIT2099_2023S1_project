package game.actors;

import Trading.TradeManager;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;


public abstract class Merchant extends Actor {

    public Merchant(String name, char displayChar, int hitPoints){
        super(name,displayChar,hitPoints);
        this.addCapability(Status.FRIENDLY);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        TradeManager tm = TradeManager.getInstance();
        return tm.checkForTrades(this);
    }
}