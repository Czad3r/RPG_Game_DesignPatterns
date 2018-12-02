package gameView.tiles;

import gameView.Assets;

import java.awt.image.BufferedImage;

public class ArenaWallTile extends Tile {
    public ArenaWallTile(int id) {
        super(Assets.arenaWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
