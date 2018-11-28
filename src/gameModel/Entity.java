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

    public static abstract class Builder {
        float x,y;
        int width,height;

        public Builder() { }

        public Builder x(float x) {
            if (x >= 0) this.x=x;
            else this.x = 0;
            return this;
        }

        public Builder y(float y) {
            if (y >= 0) this.y=y;
            else this.y = 0;
            return this;
        }

        public Builder width(int width) {
            if (width > 0) this.width=width;
            else width= 32;
            return this;
        }

        public Builder height(int height) {
            if (height> 0) this.height=height;
            else height= 32;
            return this;
        }

        public abstract Entity build();
    }
}
