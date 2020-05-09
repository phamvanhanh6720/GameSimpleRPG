package projectoop.entities.tile;

import projectoop.Game;
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
        g.drawImage(sprite,x* Game.TILE_SIZE,y*Game.TILE_SIZE,null);
    }

}
