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
import game.items.weapons.Club;
import game.items.weapons.GreatKnife;
import game.items.weapons.Uchigatana;

import java.util.ArrayList;

public class MerchantKale extends Actor {

    private ArrayList<Buyable> valuables = new ArrayList<>();
    public MerchantKale(){
        super("Merchant Kale",'K',100);
        valuables.add(new Club());
        valuables.add(new Uchigatana());
        valuables.add(new GreatKnife());
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