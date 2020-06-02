package projectoop.entities.creatures;

import projectoop.Board;
import projectoop.entities.AnimatedEntity;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Creature extends AnimatedEntity implements Comparable<Creature> {
    protected Board board;

    protected int direction=-1;
    protected boolean alive=true;
    protected boolean moving=false;
    protected double speed;
    protected int hp;
    protected Rectangle rectangle;
    protected int timeAfter=80;
    protected BufferedImage spriteHp;

    public Creature(int x, int y, Board board, double speed, int hp){
        this.x=x;
        this.y=y;
        this.board=board;
        this.speed=speed;
        this.hp=hp;

    }

    @Override
    public abstract void update();

    @Override
    public abstract void render(Graphics g);
    public abstract void calculateMove();
    public abstract void move(double xa, double ya);
    public abstract void afterBeKilled();
    public void checkBeKilled() {
        if (hp <= 0) {
            alive = false;
        }
    }

    public abstract boolean canMove(double x, double y);
    public abstract void setRectangle();
    public abstract  void chooseSprite();
    public void chooseSpriteHp(int MAX_HP,int hp){
        if(hp>MAX_HP*3/4){
            spriteHp= Sprite.hp100;
            return;
        }
        if(hp>MAX_HP/2){
            spriteHp=Sprite.hp75;
            return;
        }
        if(hp>MAX_HP/4){
            spriteHp=Sprite.hp50;
            return;
        }
        if(hp>0){
            spriteHp= Sprite.hp25;
            return;
        }
        spriteHp=Sprite.hp0;
        return;
    }
    @Override
    public int compareTo(Creature creature){
        if(getYCenter()==creature.getYCenter()){
            return 0;
        }
        else if(getYCenter()>creature.getYCenter()){
            return 1;
        }
        else{
            return -1;
        }
    }
    /*
    |----------------------------------
    |Get and Set
    |----------------------------------
     */
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
    public void setDirection(int direction){
        this.direction=direction;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp=hp;
    }

}
