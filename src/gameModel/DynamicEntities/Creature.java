package gameModel.DynamicEntities;

import gameController.Handler;
import gameModel.StaticEnities.Entity;
import gameView.Animation;
import gameView.Assets;
import gameView.tiles.Tile;

import java.awt.*;

public abstract class Creature extends Entity {
    protected int attackPoints;
    protected int armorPoints;
    protected String name;
    protected int lastMoveSide;
    protected Animation animation;
    protected boolean attacking=false;

    public static final int DEFAULT_ATTACK = 3;
    public static final int DEFAULT_ARMOR = 2;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;



    public Creature(float x, float y, Handler handler) {
        super(handler,x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
        attackPoints = DEFAULT_ATTACK;
        armorPoints = DEFAULT_ARMOR;
        width = DEFAULT_CREATURE_WIDTH;
        height = DEFAULT_CREATURE_HEIGHT;
        lastMoveSide=0;
        animation=new Animation(Assets.player);
    }

    @Override
    public void render(Graphics g) {
        if(attacking){
            g.drawImage(Assets.attack,(int) (x - handler.getGameCamera().getxOffset())+8, (int) (y - handler.getGameCamera().getyOffset())-16, 16, 16, null);
            attacking=false;
        }
            g.drawImage(animation.getAnimation(lastMoveSide), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    @Override
    public void hurt(int lostHP) {
        lostHP-=armorPoints;
        super.hurt(lostHP);
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
        if (handler.getButtonHandler().left && canMoveLeft() && !checkEntityCollisions(-4,0)) {
            x-=2;
            lastMoveSide=Assets.LEFT;
        }
        if (handler.getButtonHandler().right && canMoveRight() && !checkEntityCollisions(4,0)){
            x+=2;
            lastMoveSide=Assets.RIGHT;
        }
        if (handler.getButtonHandler().up && canMoveUp() && !checkEntityCollisions(0,-4)){
            y-=2;
            lastMoveSide=Assets.BACK;
        }
        if (handler.getButtonHandler().down && canMoveDown() && !checkEntityCollisions(0,4)) {
            y+=2;
            lastMoveSide=Assets.FRONT;
        }
    }

    public boolean canMoveRight() {
        int xBorder=(int)(x+4+bounds.width+bounds.x)/ Tile.TILEWIDTH;
        if(!collisionWithTile(xBorder,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
            !collisionWithTile(xBorder,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            return true;
        return false;
    }

    public boolean canMoveLeft() {
        int xBorder=(int)(x+bounds.x-4)/ Tile.TILEWIDTH;
        if(!collisionWithTile(xBorder,(int)(y+bounds.y)/Tile.TILEHEIGHT) &&
                !collisionWithTile(xBorder,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            return true;
        return false;
    }
    public boolean canMoveUp() {
        int yBorder=(int)(y+bounds.y-4)/ Tile.TILEHEIGHT;
        if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,yBorder) &&
                !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,yBorder))
            return true;
        return false;
    }
    public boolean canMoveDown() {
        int yBorder=(int)(y+bounds.height+bounds.y+4)/ Tile.TILEHEIGHT;
        if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,yBorder) &&
                !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,yBorder))
            return true;
        return false;
    }

    public void canMove() {
        //Sekcja X
        if ((handler.getWorld().getWidth() * Assets.getWidth() - 32)  < this.getX() + 1) // Wartość 32 to szerokosć gracza
            handler.getButtonHandler().right = false; //Right side
        if ((this.getX() - 1) < 0)
            handler.getButtonHandler().left = false;//Left side

       //Sekcja Y
        if ((handler.getWorld().getHeight() * Assets.getHeight() - 32)  < this.getY() + 1) // Wartość 32 to wysokosc gracza
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

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
