package gameModel;

import gameController.Game;
import gameController.Handler;
import gameView.Assets;
import gameView.World;
import gameView.tiles.Tile;

import java.awt.*;

public abstract class Creature extends Entity {
    protected int healthPoints;
    protected int attackPoints;
    protected int armorPoints;
    protected int armorPenetrationPoints;
    protected String name;

    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_ATTACK = 3;
    public static final int DEFAULT_ARMOR = 2;
    public static final int DEFAULT_PENETRATION = 1;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;



    public Creature(float x, float y, Handler handler) {
        super(handler,x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
        healthPoints = DEFAULT_HEALTH;
        attackPoints = DEFAULT_ATTACK;
        armorPoints = DEFAULT_ARMOR;
        armorPenetrationPoints = DEFAULT_PENETRATION;
        width = DEFAULT_CREATURE_WIDTH;
        height = DEFAULT_CREATURE_HEIGHT;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //Dla celów testowania collision detection
        g.setColor(Color.red);
        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),
                (int)(y+bounds.y-handler.getGameCamera().getyOffset()),
                bounds.width,
                bounds.height);
    }


    @Override
    public void tick() {

        update(); //Checking borders of map, and then moving
        handler.getGameCamera().centerOnEntity(this);
    }

    public void update() {
        canMove();
        move();
    }

    public void move() {
        if (handler.getButtonHandler().left && canMoveLeft()) {
            x-=2;
        }
        if (handler.getButtonHandler().right && canMoveRight()) {
            x+=2;
        }
        if (handler.getButtonHandler().up && canMoveUp()) {
            y-=2;
        }
        if (handler.getButtonHandler().down && canMoveDown()) {
            y+=2;
        }
    }

    public boolean canMoveRight()
    {
        int xBorder=(int)(x+4+bounds.width+bounds.x)/ Tile.TILEWIDTH;
        if(!collisionWithTile(xBorder,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
            !collisionWithTile(xBorder,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            return true;
        return false;
    }

    public boolean canMoveLeft()
    {
        int xBorder=(int)(x+bounds.x-4)/ Tile.TILEWIDTH;
        if(!collisionWithTile(xBorder,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
                !collisionWithTile(xBorder,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            return true;
        return false;
    }
    public boolean canMoveUp()
    {
        int yBorder=(int)(y+bounds.y-4)/ Tile.TILEHEIGHT;
        if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,yBorder) &&
                !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,yBorder))
            return true;
        return false;
    }
    public boolean canMoveDown()
    {
        int yBorder=(int)(y+bounds.height+bounds.y+4)/ Tile.TILEHEIGHT;
        if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,yBorder) &&
                !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,yBorder))
            return true;
        return false;
    }

    public void canMove() {
        float xOffSet = handler.getGameCamera().getxOffset();
        float yOffset = handler.getGameCamera().getyOffset();

        //Sekcja X
        if ((World.getWidth() * Assets.getWidth() - 32)  < this.getX() + 1) // Wartość 32 to szerokosć gracza
            handler.getButtonHandler().right = false; //Right side
        if ((this.getX() - 1) < 0)
            handler.getButtonHandler().left = false;//Left side

       //Sekcja Y
        if ((World.getHeight() * Assets.getHeight() - 32)  < this.getY() + 1) // Wartość 32 to wysokosc gracza
            handler.getButtonHandler().down = false;//Down side
        if ((this.getY() - 1) < 0)
            handler.getButtonHandler().up = false; //Up side
    }
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public int getArmorPenetrationPoints() {
        return armorPenetrationPoints;
    }

    public void setArmorPenetrationPoints(int armorPenetrationPoints) {
        this.armorPenetrationPoints = armorPenetrationPoints;
    }
}
