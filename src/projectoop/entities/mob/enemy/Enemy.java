package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.Entity;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.enemy.ai.AI;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Mob {


    protected int hp;
    protected AI ai;

    protected final double MAX_STEPS;
    protected final double rest;
    protected double step;




    public Enemy(int x, int y, Board board, double speed,int hp){
        super(x,y,board,speed);
        this.hp=hp;
        MAX_STEPS= Game.TILE_SIZE/speed;
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
        animate();
        calculateMove();

    }

    @Override
    public void render(Graphics g) {
        chooseSprite();
        g.drawImage(sprite,(int)x,(int)y,null);

    }
    /*
    |-------------------------------------
    |Collide
    |-------------------------------------
    */

    @Override
    public boolean collide(Entity entity) {
        return false;
    }
    /*
    |-------------------------------------
    |Move
    |-------------------------------------
    */
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
    protected void move(double xa, double ya) {
        if(!alive) return;
        y+=ya;
        x+=xa;

    }
    @Override
    protected boolean canMove(double x, double y) {
        return true;
    }
    /*
    |-------------------------------------
    |Be Killed
    |-------------------------------------
    */
    @Override
    protected void kill() {

    }

    @Override
    protected void afterKill() {

    }


    public abstract void chooseSprite();

}
