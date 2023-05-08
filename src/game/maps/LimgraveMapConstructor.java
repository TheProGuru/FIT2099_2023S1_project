package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;

import java.util.Arrays;
import java.util.List;

public class LimgraveMapConstructor extends MapConstructor {

    private GameMap gameMap;


    @Override
    public GameMap generateMap(World world) {
        List<String> map = Arrays.asList( // NEED TO UPDATE TO NEW GAME MAP LATER
                "..nnnn................................................~~~~~~~~~~~~~~~~~~~~~" ,
                "......................#####....######..................~~~~~~~~~~~~~~~~~~~~" ,
                "..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~" ,
                "..................................__#....................~~~~~~~~~~~~~~~~~~" ,
                "......................._____........#.....................~~~~~~~~~~~~~~~~~" ,
                "......................#............_#......................~~~~~~~~~~~~~~~~" ,
                "......................#...........###......................................" ,
                "..........................................................................." ,
                "..........................................................................." ,
                "~~~~~~~~~~~.......................###___###................................" ,
                "~~~~~~~~~~~~......................________#....nnnn........................" ,
                "~~~~~~~~~~~~~U....................#________................................" ,
                "~~~~~~~~~~~~......................#___U___#....nnnn........................" ,
                "~~~~~~~~~~~.......................###___###................................" ,
                "~~~~~~~~~~..........................#___#.................................." ,
                "..........................................................................." ,
                "..........................................................................." ,
                "..........................................................................." ,
                "..####__##...........................................&&&......######..##..." ,
                "..#.....__...........................................&&&......#....____...." ,
                "..#___..............&&&..............................&&&........__.....#..." ,
                "..####__###.........&&&......................................._.....__.#..." ,
                "....................&&&.......................................###..__###..." ,
                "...........................................................................");
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
