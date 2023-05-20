package game.actors.enemies;
/**
 *
 * Created by:
 * @author Ibrahem Abdul Khalik
 * Modified by:
 *
 */
public class GodrickTheGrafted extends Enemy{
    public GodrickTheGrafted() {
        super("Godrick the Grafted",'y',6080);
        this.addCapability(Family.CASTLE_DWELLER);
        this.addCapability(Family.BOSS);
    }

    @Override
    public int generateRunes() {
        return 20000;
    }
}
