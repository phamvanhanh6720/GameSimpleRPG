package projectoop.entities.tile;

import projectoop.Game;
import projectoop.graphics.Sprite;

import java.awt.*;

public class Tree01 extends CollisionTile {
    public Tree01(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.tree01;
        setRectangle(new Rectangle(x*Game.TILE_SIZE+12,y*Game.TILE_SIZE+10,48,48));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,x* Game.TILE_SIZE,y*Game.TILE_SIZE,null);
    }
}
