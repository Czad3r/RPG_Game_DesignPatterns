package gameModel;

import gameController.Game;
import gameView.Assets;
import gameView.World;

import java.awt.*;

public abstract class HeroAbstract extends Creature {
    protected int magicMultiplier;
    protected int healingPoints;
    protected WeaponAbstract weapon;

    public static final int DEFAULT_MAGIC = 1;
    public static final int DEFAULT_HEALING = 0;

    public HeroAbstract(float x, float y,Game game) {
        super(x, y,game);
        magicMultiplier = DEFAULT_MAGIC;
        healingPoints = DEFAULT_HEALING;
    }

    public WeaponAbstract getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponAbstract weapon) {
        this.weapon = weapon;
    }


    public int getMagicMultiplier() {
        return magicMultiplier;
    }

    public void setMagicMultiplier(int magicMultiplier) {
        this.magicMultiplier = magicMultiplier;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

    @Override
    public String toString() {
        return "{" +
                "healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", armorPenetrationPoints=" + armorPenetrationPoints +
                ", magicMultiplier=" + magicMultiplier +
                ", healingPoints=" + healingPoints +
                ", weapon=" + weapon +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void tick() {

        update(); //Checking borders of map, and then moving
        game.getGameCamera().centerOnEntity(this);
    }

    public void update() {
        canMove();
        move();
    }

    public void move() {
        if (game.getButtonHandler().left) {
            x-=2;
        }
        if (game.getButtonHandler().right) {
            x+=2;
        }
        if (game.getButtonHandler().up) {
            y-=2;
        }
        if (game.getButtonHandler().down) {
            y+=2;
        }
    }

    public void canMove() {
        float xOffSet = game.getGameCamera().getxOffset();
        float yOffset = game.getGameCamera().getyOffset();
        if ((World.getWidth() * Assets.getWidth() - 32)  < this.getX() + 1) // Wartość 32 to szerokosć gracza
            game.getButtonHandler().right = false; //Right side
        if ((World.getHeight() * Assets.getHeight() - 32)  < this.getY() + 1) // Wartość 32 to wysokosc gracza
            game.getButtonHandler().down = false;//Down side
        if ((this.getX() - 1) < 0)
            game.getButtonHandler().left = false;//Left side
        if ((this.getY() - 1) < 0)
            game.getButtonHandler().up = false; //Up side
    }


    public static abstract class Builder {
        Game game;
        float x, y;
        int width, height;
        int magicMultiplier;
        int healingPoints;
        int healthPoints;
        int attackPoints;
        int armorPoints;
        int armorPenetrationPoints;
        String name;

        WeaponAbstract weapon;


        public Builder(String name,Game game) {
            this.name=name;
            this.game=game;
        }

        public Builder x(float x) {
            this.x = x;
            return this;
        }
        public Builder y(float y) {
            this.y = y;
            return this;
        }

        public Builder healthPoints(int health) {
            if(health>0)this.healthPoints=health;
            else health=100;
            return this;
        }
        public Builder attackPoints(int attackPoints) {
            if(attackPoints>0)this.attackPoints=attackPoints;
            else attackPoints=10;
            return this;
        }
        public Builder armorPoints(int armorPoints) {
            if(armorPoints>0)this.armorPoints=armorPoints;
            else armorPoints=5;
            return this;
        }
        public Builder armorPenetrationPoints(int armorPenetrationPoints) {
            if(armorPenetrationPoints>0)this.armorPenetrationPoints=armorPenetrationPoints;
            else armorPenetrationPoints=2;
            return this;
        }
        public Builder width(int width) {
            if(width>0)this.width = width;
            else this.width=32;
            return this;
        }
        public Builder height(int height) {
            if(height>0)this.height = height;
            else this.height=32;
            return this;
        }

        public Builder weapon(WeaponAbstract weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder healingPoints(int heal) {
            if (heal > 0) healingPoints = heal;
            else heal = DEFAULT_HEALING;
            return this;
        }

        public Builder magicMultiplier(int magic) {
            if (magic > 0) magicMultiplier = magic;
            else magicMultiplier = DEFAULT_MAGIC;
            return this;
        }

        public abstract HeroAbstract build();
    }
}
