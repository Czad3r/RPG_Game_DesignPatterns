package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class WoodWallWindowTile extends Tile {
    public WoodWallWindowTile(int id) {
        super(Assets.woodWallWindow, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
