package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor {
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    Enemy(String name, char displayChar,int hitPoints){
        super(name, displayChar, hitPoints);

    }

    public abstract Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display);

    public abstract ActionList allowableActions(Actor otherActor, String direction, GameMap map);
}
