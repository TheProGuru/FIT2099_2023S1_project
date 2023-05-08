package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import java.util.Arrays;
import java.util.List;

public class BossRoomMapConstructor extends MapConstructor {

    private GameMap gameMap;

    @Override
    public GameMap generateMap(World world) {
        List<String> map = Arrays.asList( // NEED TO UPDATE TO NEW GAME MAP LATER
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                "...........____..........",
                ".........................");
        this.gameMap = new GameMap(getFancyGroundFactory(), map);
        world.addGameMap(this.gameMap);
        spawnActors(this.gameMap);
        spawnGroundItems(this.gameMap);

        return gameMap;
    }

    @Override
    public void spawnActors(GameMap map) {
    }

    @Override
    public void spawnGroundItems(GameMap map) {

    }
}
