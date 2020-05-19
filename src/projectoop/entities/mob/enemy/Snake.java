package projectoop.entities.mob.enemy;

import projectoop.Board;
import projectoop.Game;
import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.ai.AILow;
import projectoop.entities.mob.enemy.ai.AIMedium;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class Snake extends Enemy {


    public Snake(int x, int y, Board board){
        super(x,y,board, Game.PLAYER_SPEED/2,Game.PLAYER_HP/5,Game.TILE_SIZE);
        ai=new AIMedium(board.getPlayer(),this);
        sprite= Sprite.snake_down;
        rectangle=new Rectangle((int)x+18,(int)y+12,28,30);
    }
    /*
    |-------------------------------------
    |Update and render
    |-------------------------------------
    */

    @Override
    public void update() {
        super.update();
        if(attack==true){
            attack();
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        chooseSpriteHp(Game.PLAYER_HP/5,hp);
        g.drawImage(spriteHp,(int)x+13,(int)y+2,null);
        renderRectangle(g);
    }
    /*
    |-------------------------------------
    |Move
    |-------------------------------------
    */

    @Override
    protected void calculateMove() {
        Player p = null;
        p = board.getPlayer();
        if(Math.sqrt(Math.pow(this.getXCentrer()-p.getXCentrer(),2)+Math.pow(this.getYCenter()-p.getYCenter(),2)) <= 40){
            moving = false;
            attack = true;
            return;
        }
        if(rectangle.intersects(board.getPlayer().getRectangle())) {
            moving=false;
            attack=true;
            return;
        }
        int xa=0,ya=0;
        if(step<=0){
            direction=ai.calculateDirection();
            step=MAX_STEPS;
        }
        if(direction==1) xa++;
        if(direction==3) xa--;
        if(direction==2) ya--;
        if(direction==0) ya++;

        if(canMove(xa,ya)){
            step-=1+rest;
            move(xa*speed,ya*speed);
            moving=true;
        }
        else{
            step=0;
            moving=false;
        }

    }


    @Override
    protected boolean canMove(double x, double y) {
        double xRec = rectangle.getX();
        double yRec = rectangle.getY();
        rectangle.setLocation((int) (xRec + x * 1), (int) (yRec + y * 1));
        java.util.List<Rectangle> staticRectangles = board.getStaticRectangles();
        List<Mob> mobs = board.getMobs();
        Iterator<Rectangle> itr1 = staticRectangles.iterator();

        while (itr1.hasNext()) {
            Rectangle tmpRectangle = itr1.next();
            if (rectangle.intersects(tmpRectangle)) {
                return false;
            }
        }
        Iterator<Mob> itr2 = mobs.iterator();
        while (itr2.hasNext()) {
            Mob tmpMob = itr2.next();
            if (tmpMob == this) {
                continue;
            } else {
                if (rectangle.intersects(tmpMob.getRectangle()))
                    return false;
            }

        }
        return true;
    }
    /*
    |-------------------------------------
    |Attack
    |-------------------------------------
    */

    @Override
    public void attack() {
        // thoi gian 1 lan tru mau, tinh theo vong lap game
        if(animate%10<2){
            subtractPlayerHp();
        }
    }
    public void subtractPlayerHp(){
        Player player=board.getPlayer();
        player.setHp(player.getHp()-1);
    }

    /*
        |-------------------------------------
        |Choose
        |-------------------------------------
        */
    @Override
    public void chooseSprite() {
        switch (direction){
            case 0:
                sprite=Sprite.snake_down;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.snake_down,Sprite.snake_down_1,Sprite.snake_down_2,Sprite.snake_down_3,animate,40);
                if(attack)
                    sprite=Sprite.movingSprite(Sprite.snake_hit_down,Sprite.snake_hit_down_1,Sprite.snake_hit_down_2,Sprite.snake_hit_down_3,animate,60);
                break;
            case 1:
                sprite=Sprite.snake_right;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.snake_right,Sprite.snake_right_1,Sprite.snake_right_2,Sprite.snake_right_3,animate,40);
                if(attack)
                    sprite=Sprite.movingSprite(Sprite.snake_hit_right,Sprite.snake_hit_right_1,Sprite.snake_hit_right_2,Sprite.snake_hit_right_3,animate,60);
                break;
            case 2:
                sprite=Sprite.snake_up;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.snake_up,Sprite.snake_up_1,Sprite.snake_up_2,Sprite.snake_up_3,animate,40);
                if(attack)
                    sprite=Sprite.movingSprite(Sprite.snake_hit_up,Sprite.snake_hit_up_1,Sprite.snake_hit_up_2,Sprite.snake_hit_up_3,animate,60);
                break;
            case 3:
                sprite=Sprite.snake_left;
                if(moving)
                    sprite=Sprite.movingSprite(Sprite.snake_left,Sprite.snake_left_1,Sprite.snake_left_2,Sprite.snake_left_3,animate,40);
                if(attack)
                    sprite=Sprite.movingSprite(Sprite.snake_hit_down,Sprite.snake_hit_down_1,Sprite.snake_hit_down_2,Sprite.snake_hit_down_3,animate,60);
                break;

        }

    }

    /*
    |-------------------------------------
    |Get and Set
    |-------------------------------------
    */
    @Override
    protected void setRectangle() {
        switch (direction){
            case 0:
                rectangle.setLocation((int)x+18,(int)y+20);
                break;
            case 2:
                rectangle.setLocation((int)x+18,(int)y+20);
                break;
            case 1:
                rectangle.setLocation((int)x+18,(int)y+20);
                break;
            case 3:
                rectangle.setLocation((int)x+18,(int)y+20);
                break;
        }
    }


    @Override
    public double getXCentrer() {
        return x+35;
    }

    @Override
    public double getYCenter() {
        return y+30;
    }
}
