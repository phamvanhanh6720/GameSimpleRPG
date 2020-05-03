package projectoop.entities.mob.enemy.ai;

import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Enemy;

public class AIMedium extends AI{
    Player player;
    Enemy enemy;
    public AIMedium(Player player,Enemy enemy){
        this.player=player;
        this.enemy=enemy;
    }
    @Override
    public int calculateDirection() {
        return 0;
    }
}
