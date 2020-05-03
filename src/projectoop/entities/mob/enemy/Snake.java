package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.enemy.ai.AILow;
import projectoop.graphics.Sprite;

import java.awt.*;

public class Snake extends Enemy {



    public Snake(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP/2);
        ai=new AILow();
        rectangle=new Rectangle(x,y, Mob.DEFUALT_WIDTH,Mob.DEFUALT_HEIGHT);
        sprite= Sprite.snake_down;
    }



    @Override
    public void chooseSprite() {
        switch (direction){
            case 0:
                sprite=Sprite.movingSprite(Sprite.snake_down,Sprite.snake_down_1,Sprite.snake_down_2,Sprite.snake_down_3,animate,40);
                break;
            case 1:
                sprite=Sprite.movingSprite(Sprite.snake_right,Sprite.snake_right_1,Sprite.snake_right_2,Sprite.snake_right_3,animate,40);
                break;
            case 2:
                sprite=Sprite.movingSprite(Sprite.snake_up,Sprite.snake_up_1,Sprite.snake_up_2,Sprite.snake_up_3,animate,40);
                break;
            case 3:
                sprite=Sprite.movingSprite(Sprite.snake_left,Sprite.snake_left_1,Sprite.snake_left_2,Sprite.snake_left_3,animate,40);
                break;

        }

    }
}
