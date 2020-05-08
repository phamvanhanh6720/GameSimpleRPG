package projectoop.entities.tile;

import projectoop.entities.Entity;
import projectoop.graphics.Sprite;

import java.awt.*;

public class GrassTile extends Tile {
    public GrassTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.grass;
    }

}
