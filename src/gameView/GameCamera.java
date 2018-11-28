package gameView;

import gameController.Game;
import gameController.Instances;
import gameModel.Entity;

public class GameCamera {

private Game game;
private Draw drawing;
    private float xOffset,yOffset;

    public GameCamera(float xOffset,float yOffset){
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.game= Instances.game;
        this.drawing=Instances.drawing;
    }

    public void centerOnEntity(Entity e){
        xOffset=e.getX()-drawing.getWIDTH() /2 +e.getWidth()/2;
        yOffset=e.getY()-drawing.getHEIGHT()/2 +e.getHeight()/2;
    }

    public void move(float xAmt,float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
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
