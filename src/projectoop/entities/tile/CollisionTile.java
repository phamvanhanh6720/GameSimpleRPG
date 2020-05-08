package projectoop.entities.tile;

import projectoop.Game;

import java.awt.*;

public class CollisionTile extends Tile {
    protected Rectangle rectangle;
    public CollisionTile(int xTile, int yTile) {
        super(xTile, yTile);
        rectangle=new Rectangle(xTile* Game.TILE_SIZE,yTile*Game.TILE_SIZE,Game.TILE_SIZE,Game.TILE_SIZE);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawRect(x*Game.TILE_SIZE,y*Game.TILE_SIZE,Game.TILE_SIZE,Game.TILE_SIZE);
    }

    public void setRectangle(Rectangle rectangle){
        this.rectangle=rectangle;
    }
    public Rectangle getRectangle(){
        return rectangle;
    }
}
