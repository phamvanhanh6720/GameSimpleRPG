package projectoop.entities.tile;

import projectoop.entities.Entity;
import projectoop.graphics.Sprite;

import java.awt.*;

public class GrassTile extends Tile {

    private Rectangle rectangle;
    public GrassTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.grass;
        rectangle=new Rectangle(xTile*64,yTile*64,64,64);
    }

    @Override
    public boolean collide(Entity entity) {
        return true;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }
}
