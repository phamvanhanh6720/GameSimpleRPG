package projectoop.entities.mob;

import projectoop.Board;
import projectoop.entities.Entity;

import java.awt.*;

public class Bullet extends Mob {
    public Bullet(int x, int y, Board board, double speed){
        super(x,y,board,speed);
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public boolean collide(Entity entity) {
        return false;
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(double xa, double ya) {

    }

    @Override
    protected void kill() {

    }

    @Override
    protected void afterKill() {

    }

    @Override
    protected boolean canMove(double x, double y) {
        return false;
    }
}
