package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellAction;
import game.actions.Buyable;
import game.actions.BuyAction;


import java.util.ArrayList;


public abstract class Merchant extends Actor {

    private ArrayList<Buyable> valuables = new ArrayList<>();
    public Merchant(String name, char displayChar, int hitPoints){
        super(name,displayChar,hitPoints);
    }

    public void addValuableToInventory(Buyable valuable) {
        valuables.add(valuable);
    }

    public ArrayList<Buyable> getValuablesInventory() {
        return valuables;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return playerAllowableActions((Player) otherActor);
    }
    public ActionList playerAllowableActions(Player player) {
        ActionList actions = new ActionList();
        for (Buyable buyable: player.getValuables()){
            actions.add(new SellAction(this, player, buyable));
        }
        for (Buyable buyable: valuables){
            actions.add(new BuyAction(this, player, buyable));
        }
        return actions;
    }
}