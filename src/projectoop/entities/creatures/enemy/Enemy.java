package projectoop.entities.creatures.enemy;

import projectoop.Board;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.Player;
import projectoop.entities.creatures.enemy.ai.AI;

import java.awt.*;

public abstract class Enemy extends Creature {

    protected AI ai;

    protected final double MAX_STEPS;
    protected final double rest;
    protected double step;
    protected boolean attack=false;




    public Enemy(int x, int y, Board board, double speed,int hp,double MAX_STEPS){
        super(x,y,board,speed,hp);


        this.MAX_STEPS=MAX_STEPS;
        rest=(MAX_STEPS-(int)MAX_STEPS)/MAX_STEPS;
        step=MAX_STEPS;

        timeAfter=20;

    }
    /*
    |-------------------------------------
    |Update & Render
    |-------------------------------------
    */
    @Override
    public void update() {
        attack=false;
        moving=false;
        if(alive==false){
            afterBeKilled();
            return;
        }
        checkBeKilled();
        animate();
        calculateMove();
        setRectangle();

    }

    @Override
    public void render(Graphics g) {
        chooseSprite();
        g.drawImage(sprite,(int)x,(int)y,null);

    }

    /*
    |-------------------------------------
    |Move
    |-------------------------------------
    */
    @Override
    public void calculateMove() {
        Player p=board.getPlayer();
        if(p==null) return;
        if(rectangle.intersects(board.getPlayer().getRectangle())) {
            moving=false;
            return;
        }
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
    public void move(double xa, double ya) {
        if(!alive) return;
        y+=ya;
        x+=xa;

    }

    /*
    |-------------------------------------
    |Attack
    |-------------------------------------
    */
    public abstract void attack();
    /*
    |-------------------------------------
    |Be Killed
    |-------------------------------------
    */

    @Override
    public void afterBeKilled() {
        if(timeAfter>0){
            timeAfter--;
        }
        else{
            remove();
        }

    }


    /*
    |-------------------------------------
    |Get and Set
    |-------------------------------------

     */
}
