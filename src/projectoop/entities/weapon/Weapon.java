package projectoop.entities.weapon;

import projectoop.Board;
import projectoop.entities.AnimatedEntity;
import projectoop.entities.creatures.Creature;

import java.awt.*;

public abstract class Weapon extends AnimatedEntity {
    protected Board board;
    protected double speed;
    protected Rectangle rectangle;
    protected int  direction;
    public Weapon(int x, int y, Board board,double speed){
        this.x=x;
        this.y=y;
        this.board=board;
        this.speed=speed;

    }

    public abstract void update();
    public abstract void render(Graphics g);


    public abstract void calculateMove();
    public abstract void move(double xa,double ya);
    // Collision
    public abstract void detectCollision(java.util.List<Rectangle> staticRectangles, java.util.List<Creature> creatures);


    public int getDirection(){
        return direction;
    }
    public void setDirection(int direction){
        this.direction=direction;
    }

}
