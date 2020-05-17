package projectoop.entities;

import projectoop.Board;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class PythonBullet extends Weapon {
    public PythonBullet(int x, int y, Board board, double speed){
        super(x,y,board,speed);
        sprite= Sprite.pythonBullet;
        rectangle=new Rectangle((int)x,(int)y,10,10);

    }
    /*
|-------------------------------------
|Update and Render
|-------------------------------------
*/
    @Override
    public void update() {
        if(animate>=100){
            remove();
            return;
        }
        detectCollision();
        animate();
        calculateMove();
        rectangle.setLocation((int)x,(int)y);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,(int)x,(int)y,null);
        g.drawRect((int)x,(int)y,10,10);
    }


    /*
    |-------------------------------------
    |Moving and Collision
    |-------------------------------------
    */
    @Override
    public void move(double xa, double ya) {
        x+=xa;
        y+=ya;

    }
    @Override
    public void calculateMove() {
        int xa=0,ya=0;
        switch(direction){
            case 0:
                ya++;
                break;
            case 1:
                xa++;
                break;
            case 2:
                ya--;
                break;
            case 3:
                xa--;
                break;

        }
        move(xa*speed,ya*speed);

    }


    // Collision
    @Override
    public void detectCollision() {
        List<Rectangle> staticRectangles=board.getStaticRectangles();
        List<Mob> mobs=board.getMobs();

        Iterator<Rectangle> itr1=staticRectangles.iterator();

        while(itr1.hasNext()){
            Rectangle tmpRectangle=itr1.next();
            if(rectangle.intersects(tmpRectangle)){
                remove();
                return;
            }
        }

        Iterator<Mob> itr2=mobs.iterator();
        while(itr2.hasNext()){
            Mob tmpMob=itr2.next();
            if(tmpMob instanceof Player){
                int hp=((Player)tmpMob).getHp();
                ((Player)tmpMob).setHp(hp-5);
                remove();
            }
            if(rectangle.intersects(tmpMob.getRectangle())){
                remove();
                return;
            }
        }
        return;


    }


}
