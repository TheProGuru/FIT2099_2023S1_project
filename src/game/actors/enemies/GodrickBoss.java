package game.actors.enemies;

public class GodrickBoss extends Enemy{
    public GodrickBoss() {
        super("Godrick the Grafted",'y',6080);
        this.addCapability(EnemyFamily.CASTLE_DWELLER);
    }

    @Override
    public int generateRunes() {
        return 20000;
    }
}
