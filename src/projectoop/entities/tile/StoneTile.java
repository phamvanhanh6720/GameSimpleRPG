package projectoop.entities.tile;

import projectoop.entities.Entity;

import java.awt.image.BufferedImage;

public class StoneTile extends CollisionTile {
    public StoneTile(int xTile, int yTile, BufferedImage sprite) {
        super(xTile, yTile);
        this.sprite=sprite;
    }


}
