package projectoop.entities.tile;

import projectoop.graphics.Sprite;

public class GroundTile extends Tile {
    public GroundTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.ground;
    }
}
