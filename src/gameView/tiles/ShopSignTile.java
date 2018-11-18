package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class ShopSignTile extends Tile {
    public ShopSignTile(int id) {
        super(Assets.shopSign, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
