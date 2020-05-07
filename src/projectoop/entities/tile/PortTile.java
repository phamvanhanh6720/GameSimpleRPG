package projectoop.entities.tile;

import projectoop.graphics.Sprite;

public class PortTile extends Tile {
    public PortTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.port;
    }
}
