package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.enemy.ai.AILow;
import projectoop.graphics.Sprite;

public class Dragon extends Enemy {


    public Dragon(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP);
        ai=new AILow();
        sprite= Sprite.dragon_down;
    }
    @Override
    public void chooseSprite() {

    }
}
