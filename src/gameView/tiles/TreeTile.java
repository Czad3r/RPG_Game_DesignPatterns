package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class TreeTile extends Tile {
    public TreeTile(int id) {
        super(Assets.tree, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
