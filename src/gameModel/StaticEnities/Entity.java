package gameModel.StaticEnities;

import gameController.Handler;

import java.awt.*;

public abstract class Entity {
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean active = true;
    protected int healthPoints;

    public static final int DEFAULT_HEALTH = 100;


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        healthPoints = DEFAULT_HEALTH;
        this.width = width;
        this.height = height;
        this.handler = handler;
        this.bounds = new Rectangle(4, 4, width - 6, height - 6);
    }

    public void hurt(int lostHP){
        healthPoints-=lostHP;
        if(healthPoints<=0){
            active=false;
            die();
        }
    }

    public abstract void die();

    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
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


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void render(Graphics g);

    public abstract void tick();


}
