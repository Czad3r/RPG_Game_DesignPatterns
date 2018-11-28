package gameModel;

import gameController.Game;
import gameController.Instances;
import gameView.Assets;
import gameView.World;

import java.awt.*;

import static gameController.Instances.game;

public abstract class HeroAbstract extends Creature {
    protected int magicMultiplier;
    protected int healingPoints;
    protected WeaponAbstract weapon;

    public static final int DEFAULT_MAGIC = 1;
    public static final int DEFAULT_HEALING = 0;

    public HeroAbstract(float x, float y) {
        super(x, y);
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
            x--;
        }
        if (game.getButtonHandler().right) {
            x++;
        }
        if (game.getButtonHandler().up) {
            y--;
        }
        if (game.getButtonHandler().down) {
            y++;
        }
    }

    public void canMove() {
        float xOffSet = game.getGameCamera().getxOffset();
        float yOffset = game.getGameCamera().getyOffset();
        if ((World.getWidth() * Assets.getWidth() - Instances.drawing.getCHARACTER_WIDTH())  < Instances.player.getX() + 1)
            game.getButtonHandler().right = false; //Right side
        if ((World.getHeight() * Assets.getHeight() - Instances.drawing.getCHARACTER_HEIGHT())  < Instances.player.getY() + 1)
            game.getButtonHandler().down = false;//Down side
        if ((Instances.player.getX() - 1) < 0)
            game.getButtonHandler().left = false;//Left side
        if ((Instances.player.getY() - 1) < 0)
            game.getButtonHandler().up = false; //Up side
    }


    public static abstract class Builder extends Creature.Builder {
        int magicMultiplier;
        int healingPoints;

        WeaponAbstract weapon;

        public Builder(String name) {
            super(name);
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
