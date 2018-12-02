package gameModel;

import gameController.Handler;
import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.handler=handler;
        this.bounds=new Rectangle(4,4,width-6,height-6);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public abstract void render(Graphics g);

    public abstract void tick();


}
