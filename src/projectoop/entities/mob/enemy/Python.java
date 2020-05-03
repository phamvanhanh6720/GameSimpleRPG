package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.enemy.ai.AIMedium;

public class Python extends Enemy {

    public Python(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP/2);
        ai=new AIMedium(board.getPlayer(),this);
    }

    @Override
    public void chooseSprite() {

    }
}
