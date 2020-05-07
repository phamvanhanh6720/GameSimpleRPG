package projectoop.entities.tile;

import projectoop.graphics.Sprite;

public class LakeTile extends Tile {
    public LakeTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.lake;
    }
}
