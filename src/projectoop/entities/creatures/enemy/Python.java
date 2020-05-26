package projectoop.entities.creatures.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.creatures.Player;
import projectoop.entities.weapon.PythonBullet;
import projectoop.entities.creatures.Creature;
import projectoop.entities.creatures.enemy.ai.AILow;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class Python extends Enemy {


    private int timeBetweenShot;
    public Python(int x, int y, Board board){
        super(x,y,board, Player.PLAYER_SPEED/2,Player.PLAYER_HP/10,Game.TILE_SIZE*2);
        ai=new AILow();
        sprite= Sprite.python_down;
        rectangle=new Rectangle((int)x+5,(int)y+8,32,36);
        timeBetweenShot=15;
    }
    /*
    |-------------------------------------
    |Update and Render
    |-------------------------------------
    */
    @Override
    public void update() {
        if(alive==false){
            afterBeKilled();
            return;
        }
        animate();
        chooseState();
        checkBeKilled();
        if(attack){
            if(timeBetweenShot<0){
                chooseDirection();
                attack();
                timeBetweenShot=15;
            }
            else{
                timeBetweenShot--;
            }

        }
        else{
            calculateMove();
            setRectangle();
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        chooseSpriteHp(Player.PLAYER_HP/10,hp);
        g.drawImage(spriteHp,(int)x+4,(int)y-8,null);
    }
    /*
    |----------------------------
    |Attack
    |----------------------------
    */
    @Override
    public void attack(){
        int xBullet=0,yBullet=0;
        switch(direction){
            case 0:
                xBullet=(int)(x+Sprite.python_left.getWidth()/3);
                yBullet=(int)(y+Sprite.python_left.getHeight()*3/4);
                break;
            case 1:
                xBullet=(int)(x+Sprite.python_left.getWidth()*3/4);
                yBullet=(int)(y+Sprite.python_left.getHeight()/4);
                break;
            case 2:
                xBullet=(int)(x+Sprite.python_left.getWidth()/3);
                yBullet=(int)(y+Sprite.python_left.getHeight()/4);
                break;
            case 3:
                xBullet=(int)(x+Sprite.python_left.getWidth()/4);
                yBullet=(int)(y+Sprite.python_left.getHeight()/4);
                break;
        }
        PythonBullet pythonBullet=new PythonBullet(xBullet,yBullet,board,Player.PLAYER_SPEED*1.5);
        pythonBullet.setDirection(direction);
        board.addBullets(pythonBullet);

    }

/*
|----------------------------
|Move
|----------------------------
 */

    @Override
    public boolean canMove(double x, double y) {
        double xRec=rectangle.getX();
        double yRec=rectangle.getY();
        rectangle.setLocation((int)(xRec+x*1),(int)(yRec+y*1));

        List<Rectangle> staticRectangles= board.getStaticRectangles();
        List<Creature> creatures=board.getCreatures();
        Iterator<Rectangle> itr1=staticRectangles.iterator();

        while(itr1.hasNext()){
            Rectangle tmpRectangle =itr1.next();
            if(rectangle.intersects(tmpRectangle)) {
                return false;
            }
        }
        Iterator<Creature> itr2=creatures.iterator();
        while(itr2.hasNext()){
            Creature creature=itr2.next();
            if(creature==this){
                continue;
            }
            else{
                if(rectangle.intersects(creature.getRectangle()))
                    return false;
            }

        }

        return true;
    }

    /*
    |----------------------------
    |Choose
    |----------------------------
     */
    @Override
    public void chooseSprite() {
        switch(direction){
            case 0:
                sprite=Sprite.python_down;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_down,Sprite.python_down_1,Sprite.python_down_2,Sprite.python_down_3,animate,40);
                break;
            case 1:
                sprite=Sprite.python_right;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_right,Sprite.python_right_1,Sprite.python_right_2,animate,40);
                break;
            case 2:
                sprite=Sprite.python_up;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_up,Sprite.python_up_1,Sprite.python_up_2,animate,40);
                break;
            case 3:
                sprite=Sprite.python_left;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.python_left,Sprite.python_left_1,Sprite.python_left_2,animate,40);
                break;


        }

    }



    public void chooseState(){
        int calc=animate%400;
        if(calc<=300){
            moving=true;
            attack=false;
            return;
        }
        else{
            moving=false;
            attack=true;
            return;
        }
    }
    //Choose direction before attack
    public void chooseDirection(){
        if (getXCentrer()>board.getPlayer().getXCentrer()){
            setDirection(3);
        }
        else{
            setDirection(1);
        }
    }
    /*
    |-------------------------------------
    |Get and Set
    |-------------------------------------
    */
    @Override
    public void setRectangle() {
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+5,(int)y+8);
                break;
            case 2:
                rectangle.setLocation((int)x+5,(int)y+8);
                break;
            case 1:
                rectangle.setLocation((int)x+13,(int)y+8);
                break;
            case 3:
                rectangle.setLocation((int)x+2,(int)y+8);
                break;
        }

    }

    @Override
    public double getXCentrer() {
        return x+Sprite.python_down.getWidth()/2;
    }

    @Override
    public double getYCenter() {
        return y+Sprite.python_down.getHeight()/2;
    }

}
