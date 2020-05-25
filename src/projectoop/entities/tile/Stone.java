package projectoop.entities.tile;

import projectoop.graphics.Sprite;

import java.awt.*;

public class Stone extends CollisionTile {
    public Stone(int x, int y) {
        super(x, y);
        sprite= Sprite.stone;
        rectangle=new Rectangle(x+3,y+3,30,30);
    }
    @Override
    public void render(Graphics g){
        g.drawImage(sprite,x,y,null);
    }
}
