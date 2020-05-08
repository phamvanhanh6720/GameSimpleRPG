package projectoop.entities.mob;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.Entity;
import projectoop.entities.tile.GrassTile;
import projectoop.entities.tile.StoneTile;
import projectoop.graphics.Sprite;
import projectoop.input.KeyBoard;

import java.awt.*;

public class Player extends Mob {

    private List<Bullet> bullets;
    private List<StoneTile> stones;

    private KeyBoard input;
    private boolean shot=false;
    private int timeBetweenShot=0;

    private int mp=100,hp=100;


    public Player(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED);

        sprite=Sprite.player_down;
        input=board.getInput();
        rectangle=new Rectangle((int)x+17,(int)y+25,13,16);
    }
    /*
    |-------------------------------------
    |Update & Render
    |-------------------------------------
     */
    @Override
    public void update() {
        animate();
        calculateMove();
        detectAttack();
        detectPlaceStone();
        setRectangle();

    }

    @Override
    public void render(Graphics g) {
        chooseSprite();
        g.drawImage(sprite,(int)x,(int)y,null);
        //g.drawRect((int)x+17,(int)y+25,13,16);
        renderRectangle(g);
    }

    /*
    |-------------------------------------
    |Collide
    |-------------------------------------
    */

    @Override
    public boolean collide(Entity entity) {
        return false;
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
        rectangle.setLocation((int)x+14,(int)y+25);


    }
    @Override
    protected boolean canMove(double x, double y) {
        /*
        GrassTile a=(GrassTile)board.getEntities();
        rectangle.setLocation((int)(this.x+14+x*3),(int)(this.y+25+y*3));
        if(rectangle.intersects(a.getRectangle())) {
            return false;
        }
        else {
            return true;
        }

         */
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

    }
    public void attack(){

    }
    /*
    |-------------------------------------
    |Attack
    |-------------------------------------
    */
    public void detectPlaceStone(){

    }
    public void placeStone(){

    }
    private void chooseSprite(){
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
    // Size collision box: 13,16
    protected void setRectangle(){
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+17,(int)y+25);
                break;
            case 2:
                rectangle.setLocation((int)x+17,(int)y+25);
                break;
            case 1:
                rectangle.setLocation((int)x+26,(int)y+25);
                break;
            case 3:
                rectangle.setLocation((int)x+9,(int)y+25);
                break;



        }
    }
    public void renderRectangle(Graphics g){
        switch (direction){
            case 0:
                g.drawRect((int)x+17,(int)y+25,13,16);
                break;
            case 2:
                g.drawRect((int)x+17,(int)y+25,13,16);
                break;
            case 1:
                g.drawRect((int)x+26,(int)y+25,13,16);
                break;
            case 3:
                g.drawRect((int)x+9,(int)y+25,13,16);
                break;
        }

    }
}
