package projectoop.entities.weapon;

import projectoop.Board;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.Player;
import projectoop.entities.creatures.enemy.Python;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class PythonBullet extends Weapon {
    public PythonBullet(int x, int y, Board board, double speed){
        super(x,y,board,speed);
        rectangle=new Rectangle((int)x,(int)y,10,10);

    }
    /*
|-------------------------------------
|Update and Render
|-------------------------------------
*/
    @Override
    public void update() {
        chooseSprite(direction);
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


    // Collision
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
            if(creature instanceof Python){
                continue;
            }
            if(creature instanceof Player){
                if(rectangle.intersects(creature.getRectangle()))
                {
                    int hp=((Player)creature).getHp();
                    ((Player)creature).setHp(hp-5);
                    remove();
                    return;
                }
            }
            if (rectangle.intersects(creature.getRectangle())){
                remove();
                return;
            }
        }
        return;


    }
    public void chooseSprite(int direction){
        switch (direction){
            case 0:
                this.sprite = Sprite.python_bullet_down;
                break;
            case 3:
                this.sprite = Sprite.python_bullet_left;
                break;
            case 2:
                this.sprite = Sprite.python_bullet_up;
                break;
            case 1:
                this.sprite = Sprite.python_bullet_right;
                break;
        }
    }


}
