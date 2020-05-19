package projectoop.entities.mob;

import projectoop.Board;
import projectoop.entities.AnimatedEntity;
import projectoop.graphics.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Mob extends AnimatedEntity {
    protected Board board;

    public static final int DEFUALT_WIDTH=48;
    public static final int DEFUALT_HEIGHT=48;
    protected int direction=-1;
    protected boolean alive=true;
    protected boolean moving=false;
    protected double speed;
    protected int hp;
    protected Rectangle rectangle;
    public int timeAfter=80;
    protected BufferedImage spriteHp;

    public Mob(int x, int y,Board board,double speed,int hp){
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
    protected abstract void calculateMove();
    protected abstract void move(double xa, double ya);
    protected abstract void kill();
    protected abstract void afterKill();
    protected abstract boolean canMove(double x, double y);
    protected abstract void setRectangle();
    protected abstract  void chooseSprite();
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
    public void renderRectangle(Graphics g){
        g.drawRect((int)rectangle.getX(),(int)rectangle.getY(),(int)rectangle.getWidth(),(int)rectangle.getHeight());

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
    public void setDirection(int direction){
        this.direction=direction;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }

}
