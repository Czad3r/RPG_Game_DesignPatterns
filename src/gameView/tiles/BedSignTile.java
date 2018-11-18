package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class BedSignTile extends Tile {
    public BedSignTile(int id) {
        super(Assets.bedSign, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
