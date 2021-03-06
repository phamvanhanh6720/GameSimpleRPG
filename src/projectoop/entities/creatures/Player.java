package projectoop.entities.creatures;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Iterator;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.tile.Stone;
import projectoop.entities.weapon.PlayerBullet;
import projectoop.graphics.Sprite;
import projectoop.input.KeyBoard;

import java.awt.*;

public class Player extends Creature {

    public final static double PLAYER_SPEED=1.0;
    public final static int PLAYER_HP=100;
    public final static int PLAYER_MP=100;

    private KeyBoard input;
    private int timeBetweenShot=30;
    private int timeBetweenPlace=15;

    private int mp=Player.PLAYER_MP;
    private BufferedImage spriteMp;

    public Player(int x, int y, Board board){
        super(x,y,board, PLAYER_SPEED,PLAYER_HP);

        sprite=Sprite.player_down;
        input=board.getInput();
        rectangle=new Rectangle((int)x+9,(int)y+8,32,36);
        spriteHp=Sprite.hp100;
        spriteMp=Sprite.mp100;
        direction=0;

    }
    /*
    |-------------------------------------
    |Update & Render
    |-------------------------------------
     */
    @Override
    public void update() {
        if(alive==false){
            afterBeKilled();
            return;
        }
        checkBeKilled();
        if(timeBetweenShot<-7500){
            timeBetweenShot=0;
        }
        else{
            timeBetweenShot--;
        }
        if(timeBetweenPlace<-2000){
            timeBetweenPlace=0;
        }
        else{
            timeBetweenPlace--;
        }
        //cong mp theo thoi gian
        if(animate%40==0&& mp<100){
            mp+=5;
        }

        animate();
        calculateMove();
        detectAttack();
        detectPlaceStone();
        setRectangle();


    }

    @Override
    public void render(Graphics g) {
        chooseSprite();
        chooseSpriteMp(Player.PLAYER_MP,mp);
        chooseSpriteHp(Player.PLAYER_HP,hp);

        g.drawImage(sprite,(int)x,(int)y,null);
        g.drawImage(spriteHp,(int)x+4,(int)y-15,null);
        g.drawImage(spriteMp,(int)x+4,(int)y-8,null);

    }


    /*
    |-------------------------------------
    |Moving
    |-------------------------------------
    */
    @Override
    public void calculateMove() {
        int xa=0; int ya=0;
        if(input.up) ya--;
        if(input.down)ya++;
        if(input.left)xa--;
        if(input.right)xa++;
        if(xa!=0||ya!=0){
            moving=true;
            move(xa*speed,ya*speed);

        }
        else{
            moving=false;
        }
    }

    @Override
    public void move(double xa, double ya) {
        if(xa>0) direction=1;
        if(xa<0) direction=3;
        if(ya>0) direction=0;
        if(ya<0) direction=2;

        if(canMove(xa,ya)){
            x+=xa;
            y+=ya;
        }
        else
            moving=false;

    }
    @Override
    public boolean canMove(double x, double y) {

        double xRec=rectangle.getX();
        double yRec=rectangle.getY();
        rectangle.setLocation((int)(xRec+x*3),(int)(yRec+y*3));
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
            if(creature instanceof Player){
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
    |-------------------------------------
    |Be Killed
    |-------------------------------------
    */

    @Override
    public void afterBeKilled() {
        if (timeAfter>0){
            timeAfter--;
        }
        else{
            board.setPause(true);
            remove();
        }

    }

    /*
    |-------------------------------------
    |Attack
    |-------------------------------------
    */
    public void detectAttack(){
        if(input.space&&timeBetweenShot<0&&mp>0){
            double xBullet=0,yBullet=0;
            switch(direction){
                case 0:
                    xBullet=x+Sprite.player_down.getWidth()/2.5+4;
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;
                case 1:
                    xBullet=x+Sprite.player_down.getWidth();
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;
                case 2:
                    xBullet=x+Sprite.player_down.getWidth()/2.5+4;
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;
                case 3:
                    xBullet=x;
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;

            }
            attack((int)xBullet,(int)yBullet);
            timeBetweenShot=15;

        }

    }
     public void attack(int xBullet, int yBullet){
        PlayerBullet playerBullet =new PlayerBullet(xBullet,yBullet,board,Player.PLAYER_SPEED*1.5);
        playerBullet.setDirection(direction);
        board.addBullets(playerBullet);
        mp-=8;
    }
    /*
    |-------------------------------------
    |Skill Place Stone
    |-------------------------------------
    */
    public void detectPlaceStone(){
        if(timeBetweenPlace<0&&(mp/80)>=1&&input.skill){
            System.out.println(direction);
            double xStone=0,yStone=0;
            switch (direction){
                case 2:
                    xStone=x+9;
                    yStone=y+8+38;
                    break;
                case 3:
                    xStone=x+13+32;
                    yStone=y+8;
                    break;
                case 0:
                    xStone=x+7;
                    yStone=y+8-30-2;
                    break;
                case 1:
                    xStone=x+3-30-2;
                    yStone=y+8;
                    break;
            }
            placeStone((int)xStone,(int)yStone);
            timeBetweenPlace=30;
        }

    }
    public void placeStone(int xStone, int yStone){
        Stone stone=new Stone(xStone,yStone);
        if(canPlaceStone(stone)==true) {
            board.addForeground(stone);
            board.addStaticRectangles(stone.getRectangle());
            mp -= 80;
        }

    }
    public boolean canPlaceStone(Stone stone){
        List<Rectangle> staticRectangles=board.getStaticRectangles();
        Iterator<Rectangle> itr=staticRectangles.iterator();
        while(itr.hasNext()){
            if(stone.getRectangle().intersects(itr.next())){
                return false;
            }
        }
        List<Creature> creatures=board.getCreatures();
        Iterator<Creature> itr1=creatures.iterator();
        while(itr1.hasNext()){
            Creature creature=itr1.next();
            if(creature instanceof Player){
                continue;
            }
            if(stone.getRectangle().intersects(creature.getRectangle())){
                return false;
            }
        }
        return true;

    }
    /*
    |-------------------------------------
    |Choose sprite and spriteMP, spriteHP
    |-------------------------------------
    */
    public void chooseSprite(){
        switch (direction){
            case 0:
                sprite=Sprite.player_down;
                if(moving){
                    sprite=Sprite.movingSprite(Sprite.player_down,Sprite.player_down_1,Sprite.player_down_2,Sprite.player_down_3,animate,40);
                }
                break;
            case 1:
                sprite=Sprite.player_right;
                if(moving){
                    sprite=Sprite.movingSprite(Sprite.player_right,Sprite.player_right_1,Sprite.player_right_2,Sprite.player_right_3,animate,40);
                }

                break;
            case 2:
                sprite=Sprite.player_up;
                if(moving){
                    sprite=Sprite.movingSprite(Sprite.player_up,Sprite.player_up_1,Sprite.player_up_2,Sprite.player_up_3,animate,40);
                }

                break;
            case 3:
                sprite=Sprite.player_left;
                if(moving){
                    sprite=Sprite.movingSprite(Sprite.player_left,Sprite.player_left_1,Sprite.player_left_2,Sprite.player_left_3,animate,40);
                }

                break;
        }
    }
    public void chooseSpriteMp(int MAX_MP,int mp){
        if(mp> MAX_MP*3/4){
            spriteMp= Sprite.mp100;
            return;
        }
        if(mp>MAX_MP/2){
            spriteMp=Sprite.mp75;
            return;
        }
        if(mp>MAX_MP/4){
            spriteMp=Sprite.mp50;
            return;
        }
        if(mp>0){
            spriteMp= Sprite.mp25;
            return;
        }
        spriteMp=Sprite.mp0;
        return;
    }
    /*
    |----------------------------------
    |Get and Set
    |----------------------------------
     */
    public void setRectangle(){
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+9,(int)y+8);
                break;
            case 2:
                rectangle.setLocation((int)x+7,(int)y+8);
                break;
            case 1:
                rectangle.setLocation((int)x+13,(int)y+8);
                break;
            case 3:
                rectangle.setLocation((int)x+3,(int)y+8);
                break;



        }
    }


    @Override
    public double getXCentrer() {
        return x+25;
    }

    @Override
    public double getYCenter() {
        return y+25;
    }
    public int getMp(){
        return mp;
    }
    public void setMp(int mp){
        this.mp=mp;
    }


}
