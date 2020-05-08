package projectoop.entities.tile;

import projectoop.Game;
import projectoop.graphics.Sprite;

import java.awt.*;

public class BigTree extends CollisionTile {
    public BigTree(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.bigtree;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,x* Game.TILE_SIZE,y*Game.TILE_SIZE,null);
        //g.drawRect();
    }
}
