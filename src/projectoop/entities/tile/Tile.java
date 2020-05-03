package projectoop.entities.tile;

import projectoop.entities.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends Entity {
    protected int x;
    protected int y;
    public Tile(int xTile, int yTile){
        x=xTile;
        y=yTile;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite,x*64,y*64,null);
        g.drawRect(x*64,y*64,64,64);
    }

    @Override
    public boolean collide(Entity entity) {
        return false;
    }
}
