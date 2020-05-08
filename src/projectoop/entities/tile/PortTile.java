package projectoop.entities.tile;

import projectoop.Game;
import projectoop.graphics.Sprite;

import java.awt.*;

public class PortTile extends CollisionTile {
    public PortTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.port;
        setRectangle(new Rectangle(xTile* Game.TILE_SIZE,yTile*Game.TILE_SIZE,Game.TILE_SIZE,Game.TILE_SIZE*2));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,x* Game.TILE_SIZE,y*Game.TILE_SIZE,null);
        g.drawRect(x*Game.TILE_SIZE,y*Game.TILE_SIZE,Game.TILE_SIZE,Game.TILE_SIZE*2);
    }
}
