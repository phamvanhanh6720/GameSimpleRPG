package projectoop.entities.mob.enemy.ai;

import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Enemy;

public class AIMedium extends AI{
    Player player;
    Enemy enemy;
    //int tmp=1;
    public AIMedium(Player player,Enemy enemy){
        this.player=player;
        this.enemy=enemy;

    }
    @Override
    public int calculateDirection() {
        if(player==null)
            return random.nextInt(4);
        int tmp=random.nextInt(2);
        if(tmp==1){
            int v=calculateRowDirection();
            if(v!=-1){
                return v;
            }
            else {
                return calcualteColDirection();
            }
        }
        else{
            int h=calcualteColDirection();
            if(h!=-1)
                return h;
            else
                return calculateRowDirection();
        }
    }
    public int calcualteColDirection(){
        if(player.getXCentrer()<enemy.getXCentrer())
            return 3;
        else if(player.getXCentrer()>enemy.getXCentrer())
            return 1;
        return -1;
    }
    public int calculateRowDirection(){
        if(player.getYCenter()<enemy.getYCenter())
            return 2;
        else if(player.getYCenter()>enemy.getYCenter())
            return 0;
        return -1;
    }
}
