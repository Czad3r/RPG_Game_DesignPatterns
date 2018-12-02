package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class MonumentTile extends Tile {
    public MonumentTile(int id) {
        super(Assets.monument, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
