package gameView;

import gameController.Handler;
import gameModel.StaticEnities.Entity;
import gameView.tiles.Tile;

public class GameCamera {

private Handler handler;
    private float xOffset,yOffset;

    public GameCamera(float xOffset, float yOffset, Handler handler){
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handler= handler;
    }

    public void centerOnEntity(Entity e){
        xOffset=e.getX()-handler.getWidth() /2 +e.getWidth()/2;
        yOffset=e.getY()-handler.getHeight()/2 +e.getHeight()/2;
        checkBlankSpace();
    }

    public void move(float xAmt,float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
        checkBlankSpace();
    }

    public void checkBlankSpace(){
        if(xOffset < 0)xOffset=0;
        if(yOffset < 0)yOffset=0;
        int checkRight=handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        int checkDown=handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        if(xOffset > checkRight)xOffset=checkRight;
        if(yOffset > checkDown)yOffset=checkDown;

    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
