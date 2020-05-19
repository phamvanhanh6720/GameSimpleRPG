package projectoop.entities.mob;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.Bullet;
import projectoop.entities.Entity;
import projectoop.entities.tile.GrassTile;
import projectoop.entities.tile.StoneTile;
import projectoop.graphics.Sprite;
import projectoop.input.KeyBoard;

import java.awt.*;

public class Player extends Mob {



    private KeyBoard input;
    private boolean shot=false;
    private int timeBetweenShot=0;
    private int mp=Game.PLAYER_MP;
    private BufferedImage spriteMp;

    public Player(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED,Game.PLAYER_HP);

        sprite=Sprite.player_down;
        input=board.getInput();
        rectangle=new Rectangle((int)x+9,(int)y+8,32,36);
        spriteHp=Sprite.hp100;
        spriteMp=Sprite.mp100;

    }
    /*
    |-------------------------------------
    |Update & Render
    |-------------------------------------
     */
    @Override
    public void update() {
        if(alive==false){
            afterKill();
            return;
        }
        if(timeBetweenShot<-7500){
            timeBetweenShot=0;
        }
        else{
            timeBetweenShot--;
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
        System.out.println(mp);

    }

    @Override
    public void render(Graphics g) {
        chooseSprite();
        chooseSpriteMp(Game.PLAYER_MP,mp);
        chooseSpriteHp(Game.PLAYER_HP,hp);
        g.drawImage(sprite,(int)x,(int)y,null);
        g.drawImage(spriteHp,(int)x+4,(int)y-15,null);
        g.drawImage(spriteMp,(int)x+4,(int)y-8,null);

        renderRectangle(g);
    }


    /*
    |-------------------------------------
    |Moving
    |-------------------------------------
    */
    @Override
    protected void calculateMove() {
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
    protected void move(double xa, double ya) {
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
        //rectangle.setLocation((int)x+13,(int)y+16);


    }
    @Override
    protected boolean canMove(double x, double y) {

        double xRec=rectangle.getX();
        double yRec=rectangle.getY();
        rectangle.setLocation((int)(xRec+x*3),(int)(yRec+y*3));
        List<Rectangle> staticRectangles= board.getStaticRectangles();
        List<Mob> mobs=board.getMobs();
        Iterator<Rectangle> itr1=staticRectangles.iterator();

        while(itr1.hasNext()){
            Rectangle tmpRectangle =itr1.next();
            if(rectangle.intersects(tmpRectangle)) {
                return false;
            }
        }
         Iterator<Mob> itr2=mobs.iterator();
        while(itr2.hasNext()){
            Mob tmpMob=itr2.next();
            if(tmpMob instanceof Player){
                continue;
            }
            else{
                if(rectangle.intersects(tmpMob.getRectangle()))
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
    protected void kill() {

    }

    @Override
    protected void afterKill() {

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
                    xBullet=x+Sprite.player_down.getWidth()/2.5;
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;
                case 1:
                    xBullet=x+Sprite.player_down.getWidth();
                    yBullet=y+Sprite.player_down.getHeight()/3;
                    break;
                case 2:
                    xBullet=x+Sprite.player_down.getWidth()/2.5;
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
        Bullet bullet=new Bullet(xBullet,yBullet,board,Game.PLAYER_SPEED*1.5);
        bullet.setDirection(direction);
        board.addBullets(bullet);
        mp-=5;
    }
    /*
    |-------------------------------------
    |Skill
    |-------------------------------------
    */
    public void detectPlaceStone(){

    }
    public void placeStone(){

    }
    /*
    |-------------------------------------
    |Choose
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
    protected void setRectangle(){
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+9,(int)y+8);
               // rectangle.setSize(16,36);
                break;
            case 2:
                rectangle.setLocation((int)x+7,(int)y+8);
              //  rectangle.setSize(16,38);
                break;
            case 1:
                rectangle.setLocation((int)x+13,(int)y+8);
              //  rectangle.setSize(36,15);
                break;
            case 3:
                rectangle.setLocation((int)x+3,(int)y+8);
               // rectangle.setSize(37,15);
                break;



        }
    }


    @Override
    public double getXCentrer() {
        return x+Sprite.player_down.getWidth()/2;
    }

    @Override
    public double getYCenter() {
        return y+Sprite.player_down.getHeight()/2;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp=hp;

    }

}
