package projectoop.entities.tile;

import projectoop.Game;
import projectoop.graphics.Sprite;

import java.awt.*;

public class Tree0 extends CollisionTile {
    public Tree0(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.tree0;
        setRectangle(new Rectangle(x*Game.TILE_SIZE+8,y*Game.TILE_SIZE+10,30,25));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,x* Game.TILE_SIZE,y*Game.TILE_SIZE,null);
       // g.drawRect(x*Game.TILE_SIZE+8,y*Game.TILE_SIZE+10,30,28);
    }
}
