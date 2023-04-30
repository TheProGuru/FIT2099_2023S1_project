package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.AttackAction;
import game.actions.BuyAction;
import game.actions.Buyable;

public class MerchantKale extends Actor {
    public MerchantKale(){
        super("Merchant Kale",'K',100);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return playerAllowableActions((Player) otherActor, direction, map);
    }
    public ActionList playerAllowableActions(Player player, String direction, GameMap map) {
        ActionList actions = new ActionList();
        for (Buyable buyable: player.getValuables()){
            actions.add(new BuyAction(this, player, buyable));
        }
        return actions;
    }
}