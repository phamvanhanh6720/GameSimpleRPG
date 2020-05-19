package projectoop.graphics;

import projectoop.entities.mob.Mob;
import projectoop.entities.mob.Player;
import projectoop.entities.mob.enemy.Snake;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    //public static BufferedImage grass=ImageLoader.loadImage("/textures/grass.png");
    private static SpriteSheet spriteSheet_player=new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
    private static SpriteSheet spriteSheet_snake=new SpriteSheet(ImageLoader.loadImage("/textures/snake.png"));
    private static SpriteSheet spriteSheet_snakeHit= new SpriteSheet(ImageLoader.loadImage("/textures/snake-hit.png"));
    private static SpriteSheet spriteSheet_python=new SpriteSheet(ImageLoader.loadImage("/textures/python.png"));
    private static SpriteSheet spriteSheet_pythonFight=new SpriteSheet(ImageLoader.loadImage("/textures/python_fight.png"));


    /*
    -------------------------------------------
    ---Entities
    -------------------------------------------
     */
    public static BufferedImage bullet=ImageLoader.loadImage("/textures/bullet_1.png");
    public static BufferedImage pythonBullet=ImageLoader.loadImage("/textures/pythonbullet.png");
    public static BufferedImage border=ImageLoader.loadImage("/textures/border.png");
    public static BufferedImage grass0=ImageLoader.loadImage("/textures/grass0.png");
    public static BufferedImage grass=ImageLoader.loadImage("/textures/grass.png");
    public static BufferedImage grass1=ImageLoader.loadImage("/textures/grass1.png");
    public static BufferedImage bigtree=ImageLoader.loadImage("/textures/bigtree.png");
    public static BufferedImage ground=ImageLoader.loadImage("/textures/ground.png");
    public static BufferedImage lake=ImageLoader.loadImage("/textures/lake.png");
    public static BufferedImage lake1=ImageLoader.loadImage("/textures/lake1.png");
    public static BufferedImage port=ImageLoader.loadImage("/textures/port.png");
    public static BufferedImage tree01=ImageLoader.loadImage("/textures/tree01.png");
    public static BufferedImage tree0=ImageLoader.loadImage("/textures/tree0.png");

    //hp and mp
    public static BufferedImage hp100= ImageLoader.loadImage("/textures/hp100.png");
    public static BufferedImage hp75= ImageLoader.loadImage("/textures/hp75.png");
    public static BufferedImage hp50= ImageLoader.loadImage("/textures/hp50.png");
    public static BufferedImage hp25= ImageLoader.loadImage("/textures/hp25.png");
    public static BufferedImage hp0=ImageLoader.loadImage("/textures/hp0.png");

    public static BufferedImage mp100=ImageLoader.loadImage("/textures/mp100.png");
    public static BufferedImage mp75=ImageLoader.loadImage("/textures/mp75.png");
    public static BufferedImage mp50=ImageLoader.loadImage("/textures/mp50.png");
    public static BufferedImage mp25=ImageLoader.loadImage("/textures/mp25.png");
    public static BufferedImage mp0=ImageLoader.loadImage("/textures/mp0.png");

    /*
    -------------------------------------------
    ---Player
    ---Size sprite=48*48
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
    |Size sprite= 72*72
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
    |Size sprite= 72*72
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
    |Python
    |Size sprite: 51*48==> height=51, width=48
    |------------------------
     */
    public static BufferedImage python_down=spriteSheet_python.crop(0,0,48,51);
    public static BufferedImage python_down_1=spriteSheet_python.crop(1*48,0,48,51);
    public static BufferedImage python_down_2=spriteSheet_python.crop(2*48,0,48,51);
    public static BufferedImage python_down_3=spriteSheet_python.crop(3*48,0,48,51);

    public static BufferedImage python_left=spriteSheet_python.crop(0*48,1*51,48,51);
    public static BufferedImage python_left_1=spriteSheet_python.crop(1*48,1*51,48,51);
    public static BufferedImage python_left_2=spriteSheet_python.crop(2*48,1*51,48,51);
    public static BufferedImage python_left_3=spriteSheet_python.crop(3*48,1*51,48,51);


    public static BufferedImage python_right=spriteSheet_python.crop(0*48,2*51,48,51);
    public static BufferedImage python_right_1=spriteSheet_python.crop(1*48,2*51,48,51);
    public static BufferedImage python_right_2=spriteSheet_python.crop(2*48,2*51,48,51);
    public static BufferedImage python_right_3=spriteSheet_python.crop(3*48,2*51,48,51);

    public static BufferedImage python_up=spriteSheet_python.crop(0*48,3*51,48,51);
    public static BufferedImage python_up_1=spriteSheet_python.crop(1*48,3*51,48,51);
    public static BufferedImage python_up_2=spriteSheet_python.crop(2*48,3*51,48,51);
    public static BufferedImage python_up_3=spriteSheet_python.crop(3*48,3*51,48,51);
    /*
    |------------------------
    |Python Fight
    |Size sprite: 51*48==> height=51, width=48
    |------------------------
     */
    public static BufferedImage python_fight_down=spriteSheet_pythonFight.crop(0,0,48,51);
    public static BufferedImage python_fight_down_1=spriteSheet_pythonFight.crop(1*48,0,48,51);
    public static BufferedImage python_fight_down_2=spriteSheet_pythonFight.crop(2*48,0,48,51);
    public static BufferedImage python_fight_down_3=spriteSheet_pythonFight.crop(3*48,0,48,51);

    public static BufferedImage python_fight_left=spriteSheet_pythonFight.crop(0*48,1*51,48,51);
    public static BufferedImage python_fight_left_1=spriteSheet_pythonFight.crop(1*48,1*51,48,51);
    public static BufferedImage python_fight_left_2=spriteSheet_pythonFight.crop(2*48,1*51,48,51);
    public static BufferedImage python_fight_left_3=spriteSheet_pythonFight.crop(3*48,1*51,48,51);


    public static BufferedImage python_fight_right=spriteSheet_pythonFight.crop(0*48,2*51,48,51);
    public static BufferedImage python_fight_right_1=spriteSheet_pythonFight.crop(1*48,2*51,48,51);
    public static BufferedImage python_fight_right_2=spriteSheet_pythonFight.crop(2*48,2*51,48,51);
    public static BufferedImage python_fight_right_3=spriteSheet_pythonFight.crop(3*48,2*51,48,51);

    public static BufferedImage python_fight_up=spriteSheet_pythonFight.crop(0*48,3*51,48,51);
    public static BufferedImage python_fight_up_1=spriteSheet_pythonFight.crop(1*48,3*51,48,51);
    public static BufferedImage python_fight_up_2=spriteSheet_pythonFight.crop(2*48,3*51,48,51);
    public static BufferedImage python_fight_up_3=spriteSheet_pythonFight.crop(3*48,3*51,48,51);










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
    public static BufferedImage movingSprite(BufferedImage normal, BufferedImage x1, BufferedImage x2,int animate, int time){
        int calc=animate%time;
        int diff=time/3;
        if(calc<diff)
            return normal;
        if(calc<diff*2)
            return x1;
        return x2;
    }
}

