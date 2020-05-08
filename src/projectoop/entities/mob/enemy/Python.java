package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.enemy.ai.AILow;
import projectoop.graphics.Sprite;

import java.awt.*;

public class Python extends Enemy {


    public Python(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP);
        ai=new AILow();
        sprite= Sprite.python_down;
        rectangle=new Rectangle((int)x+16,(int)y+25,13,17);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        renderRectangle(g);
    }

    @Override
    public void chooseSprite() {
        switch(direction){
            case 0:
                sprite=Sprite.movingSprite(Sprite.python_down,Sprite.python_down_1,Sprite.python_down_2,Sprite.python_down_3,animate,40);
                break;
            case 1:
                sprite=Sprite.movingSprite(Sprite.python_right,Sprite.python_right_1,Sprite.python_right_2,animate,40);
                break;
            case 2:
                sprite=Sprite.movingSprite(Sprite.python_up,Sprite.python_up_1,Sprite.python_up_2,animate,40);
                break;
            case 3:
                sprite=Sprite.movingSprite(Sprite.python_left,Sprite.python_left_1,Sprite.python_left_2,animate,40);
                break;


        }

    }
    // Size collision box: 13,17=> width=13, height=17
    @Override
    protected void setRectangle() {
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+16,(int)y+25);
                break;
            case 2:
                rectangle.setLocation((int)x+16,(int)y+25);
                break;
            case 1:
                rectangle.setLocation((int)x+26,(int)y+25);
                break;
            case 3:
                rectangle.setLocation((int)x+6,(int)y+25);
                break;
        }

    }

    @Override
    public void renderRectangle(Graphics g) {
        switch (direction){
            case 0:
                g.drawRect((int)x+16,(int)y+25,13,17);
                break;
            case 2:
                g.drawRect((int)x+16,(int)y+25,13,17);
                break;
            case 1:
                g.drawRect((int)x+26,(int)y+25,13,17);
                break;
            case 3:
                g.drawRect((int)x+6,(int)y+25,13,17);
                break;
        }
    }
}
