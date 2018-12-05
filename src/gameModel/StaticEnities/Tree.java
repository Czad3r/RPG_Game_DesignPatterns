package gameModel.StaticEnities;

import gameController.Handler;
import gameView.Assets;
import gameView.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity {
    public Tree(Handler handler, float x, float y) {

        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void tick() {

    }
}
