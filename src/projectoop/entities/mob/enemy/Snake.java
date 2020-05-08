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
        sprite= Sprite.snake_down;
        rectangle=new Rectangle((int)x+28,(int)y+27,12,15);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        renderRectangle(g);
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

    //Size collision box: 12*15
    @Override
    protected void setRectangle() {
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+28,(int)y+27);
                break;
            case 2:
                rectangle.setLocation((int)x+31,(int)y+27);
                break;
            case 1:
                rectangle.setLocation((int)x+34,(int)y+27);
                break;
            case 3:
                rectangle.setLocation((int)x+28,(int)y+27);
                break;
        }
    }

    @Override
    public void renderRectangle(Graphics g) {
        switch (direction){
            case 0:
                g.drawRect((int)x+28,(int)y+27,12,15);
                break;
            case 2:
                g.drawRect((int)x+31,(int)y+27,12,15);
                break;
            case 1:
                g.drawRect((int)x+34,(int)y+27,12,15);
                break;
            case 3:
                g.drawRect((int)x+28,(int)y+27,12,15);
                break;
        }
    }
}
