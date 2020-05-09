package projectoop.entities;

import projectoop.graphics.IRender;
import projectoop.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements IRender {
    protected double x,y;
    protected boolean removed=false;
    protected BufferedImage sprite;
    @Override
    public abstract void update();

    @Override
    public abstract void render(Graphics g);
    public void remove(){
        removed=true;
    }
    public boolean isRemoved(){
        return removed;
    }
    public BufferedImage getSprite() {
        return sprite;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public int getXTile(){
        return 0;
    }
    public int getYTile(){
        return 0;
    }

}