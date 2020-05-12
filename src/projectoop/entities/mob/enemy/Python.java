package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.ai.AILow;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class Python extends Enemy {


    public Python(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP,Game.TILE_SIZE);
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
    protected void calculateMove() {
        int xa=0,ya=0;
        if(step<=0){
            direction=ai.calculateDirection();
            step=MAX_STEPS;
        }
        if(direction==1) xa++;
        if(direction==3) xa--;
        if(direction==2) ya--;
        if(direction==0) ya++;

        if(canMove(xa,ya)){
            step-=1+rest;
            move(xa*speed,ya*speed);
            moving=true;
        }
        else{

            step=0;
            moving=false;
        }

    }

    @Override
    protected boolean canMove(double x, double y) {
        double xRec=rectangle.getX();
        double yRec=rectangle.getY();
        rectangle.setLocation((int)(xRec+x*1),(int)(yRec+y*1));

        List<Rectangle> staticRectangles= board.getStaticRectangles();
        List<Mob> mobs=board.getMobs();
        Iterator<Rectangle> itr1=staticRectangles.iterator();

        while(itr1.hasNext()){
            Rectangle tmpRectangle =itr1.next();
            if(rectangle.intersects(tmpRectangle)) {
                return false;
            }
        }
        Iterator<Mob> itr2=mobs.iterator();
        while(itr2.hasNext()){
            Mob tmpMob=itr2.next();
            if(tmpMob instanceof Python){
                continue;
            }
            else{
                if(rectangle.intersects(tmpMob.getRectangle()))
                    return false;
            }

        }

        return true;
    }


    @Override
    public void chooseSprite() {
        switch(direction){
            case 0:
                sprite=Sprite.python_down;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_down,Sprite.python_down_1,Sprite.python_down_2,Sprite.python_down_3,animate,40);
                break;
            case 1:
                sprite=Sprite.python_right;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_right,Sprite.python_right_1,Sprite.python_right_2,animate,40);
                break;
            case 2:
                sprite=Sprite.python_up;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_up,Sprite.python_up_1,Sprite.python_up_2,animate,40);
                break;
            case 3:
                sprite=Sprite.python_left;
                if(moving)
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
    public double getXCentrer() {
        return x+Sprite.python_down.getWidth()/2;
    }

    @Override
    public double getYCenter() {
        return y+Sprite.python_down.getHeight()/2;
    }
}
