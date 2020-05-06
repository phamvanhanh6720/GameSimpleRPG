package projectoop.graphics;

import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Snake;

import java.awt.image.BufferedImage;

public class Sprite {
    //public static BufferedImage grass=ImageLoader.loadImage("/textures/grass.png");
    private static SpriteSheet spriteSheet_player=new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
    private static SpriteSheet spriteSheet_snake=new SpriteSheet(ImageLoader.loadImage("/textures/snake.png"));
    private static SpriteSheet spriteSheet_snakeHit= new SpriteSheet(ImageLoader.loadImage("/textures/snake-hit.png"));
    private static SpriteSheet spriteSheet_dragon=new SpriteSheet(ImageLoader.loadImage("/textures/tile002.png"));

    /*
    -------------------------------------------
    ---Entities
    -------------------------------------------
     */
    public static BufferedImage border=ImageLoader.loadImage("/textures/border.png");
    public static BufferedImage grass0=ImageLoader.loadImage("/textures/grass0.png");
    public static BufferedImage grass=ImageLoader.loadImage("/textures/grass.png");
    public static BufferedImage bigtree=ImageLoader.loadImage("/textures/bigtree.png");
    public static BufferedImage ground=ImageLoader.loadImage("/textures/ground.png");
    public static BufferedImage lake=ImageLoader.loadImage("/textures/lake.png");
    public static BufferedImage lake1=ImageLoader.loadImage("/textures/lake1.png");
    public static BufferedImage port=ImageLoader.loadImage("/textures/port.png");
    public static BufferedImage tree01=ImageLoader.loadImage("/textures/tree01.png");
    public static BufferedImage tree0=ImageLoader.loadImage("/textures/tree0.png");

    /*
    -------------------------------------------
    ---Player
    -------------------------------------------
     */

    public static BufferedImage player_down=spriteSheet_player.crop(0* Mob.DEFUALT_WIDTH,0*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_down_1=spriteSheet_player.crop(1* Mob.DEFUALT_WIDTH,0*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_down_2=spriteSheet_player.crop(2* Mob.DEFUALT_WIDTH,0*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_down_3=spriteSheet_player.crop(3* Mob.DEFUALT_WIDTH,0*Mob.DEFUALT_HEIGHT,48,48);


    public static BufferedImage player_left=spriteSheet_player.crop(0*Mob.DEFUALT_WIDTH,1*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_left_1=spriteSheet_player.crop(1*Mob.DEFUALT_WIDTH,1*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_left_2=spriteSheet_player.crop(2*Mob.DEFUALT_WIDTH,1*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_left_3=spriteSheet_player.crop(3*Mob.DEFUALT_WIDTH,1*Mob.DEFUALT_HEIGHT,48,48);

    public static BufferedImage player_right=spriteSheet_player.crop(0*Mob.DEFUALT_WIDTH,2*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_right_1=spriteSheet_player.crop(1*Mob.DEFUALT_WIDTH,2*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_right_2=spriteSheet_player.crop(2*Mob.DEFUALT_WIDTH,2*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_right_3=spriteSheet_player.crop(3*Mob.DEFUALT_WIDTH,2*Mob.DEFUALT_HEIGHT,48,48);

    public static BufferedImage player_up=spriteSheet_player.crop(0*Mob.DEFUALT_WIDTH,3*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_up_1=spriteSheet_player.crop(1*Mob.DEFUALT_WIDTH,3*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_up_2=spriteSheet_player.crop(2*Mob.DEFUALT_WIDTH,3*Mob.DEFUALT_HEIGHT,48,48);
    public static BufferedImage player_up_3=spriteSheet_player.crop(3*Mob.DEFUALT_WIDTH,3*Mob.DEFUALT_HEIGHT,48,48);
    /*
    |------------------------
    |Snake
    |------------------------
     */

    public static BufferedImage snake_down=spriteSheet_snake.crop(0*72,0*72,72,72);
    public static BufferedImage snake_down_1=spriteSheet_snake.crop(1*72,0*72,72,72);
    public static BufferedImage snake_down_2=spriteSheet_snake.crop(2*72,0*72,72,72);
    public static BufferedImage snake_down_3=spriteSheet_snake.crop(3*72,0*72,72,72);


    public static BufferedImage snake_left=spriteSheet_snake.crop(0*72,1*72,72,72);
    public static BufferedImage snake_left_1=spriteSheet_snake.crop(1*72,1*72,72,72);
    public static BufferedImage snake_left_2=spriteSheet_snake.crop(2*72,1*72,72,72);
    public static BufferedImage snake_left_3=spriteSheet_snake.crop(3*72,1*72,72,72);

    public static BufferedImage snake_right=spriteSheet_snake.crop(0*72,2*72,72,72);
    public static BufferedImage snake_right_1=spriteSheet_snake.crop(1*72,2*72,72,72);
    public static BufferedImage snake_right_2=spriteSheet_snake.crop(2*72,2*72,72,72);
    public static BufferedImage snake_right_3=spriteSheet_snake.crop(3*72,2*72,72,72);

    public static BufferedImage snake_up=spriteSheet_snake.crop(0*72,3*72,72,72);
    public static BufferedImage snake_up_1=spriteSheet_snake.crop(1*72,3*72,72,72);
    public static BufferedImage snake_up_2=spriteSheet_snake.crop(2*72,3*72,72,72);
    public static BufferedImage snake_up_3=spriteSheet_snake.crop(3*72,3*72,72,72);
    /*
    |------------------------
    |Snake Hit
    |------------------------
    */
    public static BufferedImage snake_hit_down=spriteSheet_snakeHit.crop(0*72,0*72,72,72);
    public static BufferedImage snake_hit_down_1=spriteSheet_snakeHit.crop(1*72,0*72,72,72);
    public static BufferedImage snake_hit_down_2=spriteSheet_snakeHit.crop(2*72,0*72,72,72);
    public static BufferedImage snake_hit_down_3=spriteSheet_snakeHit.crop(3*72,0*72,72,72);


    public static BufferedImage snake_hit_left=spriteSheet_snakeHit.crop(0*72,1*72,72,72);
    public static BufferedImage snake_hit_left_1=spriteSheet_snakeHit.crop(1*72,1*72,72,72);
    public static BufferedImage snake_hit_left_2=spriteSheet_snakeHit.crop(2*72,1*72,72,72);
    public static BufferedImage snake_hit_left_3=spriteSheet_snakeHit.crop(3*72,1*72,72,72);

    public static BufferedImage snake_hit_right=spriteSheet_snakeHit.crop(0*72,2*72,72,72);
    public static BufferedImage snake_hit_right_1=spriteSheet_snakeHit.crop(1*72,2*72,72,72);
    public static BufferedImage snake_hit_right_2=spriteSheet_snakeHit.crop(2*72,2*72,72,72);
    public static BufferedImage snake_hit_right_3=spriteSheet_snakeHit.crop(3*72,2*72,72,72);

    public static BufferedImage snake_hit_up=spriteSheet_snakeHit.crop(0*72,3*72,72,72);
    public static BufferedImage snake_hit_up_1=spriteSheet_snakeHit.crop(1*72,3*72,72,72);
    public static BufferedImage snake_hit_up_2=spriteSheet_snakeHit.crop(2*72,3*72,72,72);
    public static BufferedImage snake_hit_up_3=spriteSheet_snakeHit.crop(3*72,3*72,72,72);

    /*
    |------------------------
    |Dragon
    |------------------------
     */
    public static BufferedImage dragon_down=spriteSheet_dragon.crop(0,0,24,32);







    public static BufferedImage movingSprite(BufferedImage normal,BufferedImage x1,BufferedImage x2, BufferedImage x3,int animate, int time){
        int calc=animate%time;
        int diff=time/4;
        if(calc<diff){
            return normal;
        }
        if(calc<diff*2){
            return x1;
        }
        if (calc<diff*3){
            return x2;
        }
        return x3;
    }
}
