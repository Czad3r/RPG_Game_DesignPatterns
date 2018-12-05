package gameModel.StaticEnities;

import gameController.Handler;
import gameView.tiles.Tile;

import java.awt.*;

public abstract class StaticEntity extends Entity {

    protected Rectangle bounds;

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        bounds=new Rectangle();
        bounds.x=0;
        bounds.y=0;
        bounds.width= Tile.TILEWIDTH;
        bounds.height=Tile.TILEHEIGHT;
    }
}
