package projectoop.entities.weapon;

import projectoop.Board;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.Player;
import projectoop.entities.creatures.enemy.Enemy;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class PlayerBullet extends Weapon {
    public PlayerBullet(int x, int y, Board board, double speed){
        super(x,y,board,speed);
        sprite= Sprite.bullet;
        rectangle=new Rectangle(x,y,10,10);

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
        List<Rectangle> staticRectangles=board.getStaticRectangles();
        List<Creature> creatures=board.getCreatures();
        detectCollision(staticRectangles,creatures);
        animate();
        calculateMove();
        rectangle.setLocation((int)x,(int)y);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,(int)x,(int)y,null);
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


    // phat hien va cham voi vat the khac thi bi xoa
    @Override
    public void detectCollision(List<Rectangle> staticRectangles, List<Creature> creatures) {
        Iterator<Rectangle> itr1=staticRectangles.iterator();

        while(itr1.hasNext()){
            Rectangle tmpRectangle=itr1.next();
            if(rectangle.intersects(tmpRectangle)){
                remove();
                return;
            }
        }

        Iterator<Creature> itr2=creatures.iterator();
        while(itr2.hasNext()){
            Creature creature=itr2.next();
            if(creature instanceof Player){
                continue;
            }
            if(rectangle.intersects(creature.getRectangle())){
                int hp=((Enemy)creature).getHp();
                ((Enemy)creature).setHp(hp-5);
                remove();
                return;
            }
        }
        return;


    }


}
