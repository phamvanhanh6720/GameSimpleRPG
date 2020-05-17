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
    protected boolean attack=false;




    public Enemy(int x, int y, Board board, double speed,int hp,double MAX_STEPS){
        super(x,y,board,speed);
        this.hp=hp;

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
        if(alive==false){
            afterKill();
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
    protected void calculateMove() {
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
    protected void move(double xa, double ya) {
        if(!alive) return;
        y+=ya;
        x+=xa;

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
    public void checkBeKilled(){
        if(hp<=0){
            remove();
        }
    }


    public abstract void chooseSprite();

    @Override
    public double getXCentrer() {
        return 0;
    }

    @Override
    public double getYCenter() {
        return 0;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp=hp;
    }
}
