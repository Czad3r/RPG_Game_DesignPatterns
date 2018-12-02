package gameModel;

import gameController.Game;

import java.awt.*;

public abstract class Entity {
    protected Game game;
    protected float x, y;
    protected int width, height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entity(Game game, float x, float y,int width,int height) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.game=game;
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
