package game.items.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.items.Consumable;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
/**
 * Golden runes are broken to give you runes
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class GoldenRunes extends Item implements Consumable {
    Action consume = new ConsumeAction(this);
    public GoldenRunes() {
        super("Golden Rune", '*', true);

    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if(!super.getAllowableActions().contains(consume)) {
            super.addAction(consume);
        }
    }
    @Override
    public void tick(Location currentLocation) {
        if(super.getAllowableActions().contains(consume)){
            super.removeAction(consume);
        }
    }
    @Override
    public String use(Actor actor, GameMap map) {
        int runes = RandomNumberGenerator.getRandomInt(200, 10000);
        RuneManager.getInstance().addRunes(runes);

        actor.removeItemFromInventory(this);

        return "Tarnished gained " + runes + " Runes.";
    }

    @Override
    public String getDescription(Actor actor) {
        return "Tarnished Breaks " + this + " apart to see what's with in.";
    }

}
