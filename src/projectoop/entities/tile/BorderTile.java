package projectoop.entities.tile;

import projectoop.graphics.Sprite;

public class BorderTile extends CollisionTile {
    public BorderTile(int xTile, int yTile) {
        super(xTile, yTile);
        sprite= Sprite.border;
    }
}
