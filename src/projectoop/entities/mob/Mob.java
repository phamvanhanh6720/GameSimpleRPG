package projectoop.entities.mob;

import projectoop.Board;
import projectoop.entities.AnimatedEntity;

import java.awt.*;

public abstract class Mob extends AnimatedEntity {
    protected Board board;

    public static final int DEFUALT_WIDTH=48;
    public static final int DEFUALT_HEIGHT=48;
    protected int direction=-1;
    protected boolean alive=true;
    protected boolean moving=false;
    protected double speed;
    protected Rectangle rectangle;
    public int timeAfter=80;

    public Mob(int x, int y,Board board,double speed){
        this.x=x;
        this.y=y;
        this.board=board;
        this.speed=speed;

    }

    @Override
    public abstract void update();

    @Override
    public abstract void render(Graphics g);
    protected abstract void calculateMove();
    protected abstract void move(double xa, double ya);
    protected abstract void kill();
    protected abstract void afterKill();
    protected abstract boolean canMove(double x, double y);
    protected abstract void setRectangle();
    public void renderRectangle(Graphics g){

    }
    public abstract double getXCentrer();
    public abstract double getYCenter();
    public boolean isAlive(){
        return alive;
    }
    public boolean isMoving(){
        return moving;
    }
    public int getDirection(){
        return direction;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }

}
