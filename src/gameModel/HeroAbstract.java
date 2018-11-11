package gameModel;

import gameController.Instances;

import javax.swing.*;

public abstract class HeroAbstract extends creature{
    int magicMultiplier;
    int healingPoints;

    //Sekcja ruchu

    boolean left, right, up, down;

    WeaponAbstract weapon;

    public WeaponAbstract getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponAbstract weapon) {
        this.weapon = weapon;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
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
                ", icon=" + icon +
                '}';
    }

    public void update() {
        canMove();
        move();
    }

    public void move() {
        if (left) {
            x--;
        }
        if (right) {
            x++;
        }
        if (up) {
            y--;
        }
        if (down) {
            y++;
        }
    }

    public void canMove() {
        if ((Instances.drawing.getWIDTH() - Instances.drawing.getCHARACTER_WIDTH()) < Instances.player.getX() + 1)
            right = false; //Right side
        if ((Instances.drawing.getHEIGHT() - Instances.drawing.getCHARACTER_HEIGHT()) < Instances.player.getY() + 1)
            down = false;//Down side
        if ((Instances.player.getX() - 1) < 0)
            left = false;//Left side
        if ((Instances.player.getY() - 1) < 0)
            up = false; //Up side
    }


    public static abstract class Builder extends creature.Builder {
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
            else heal = 0;
            return this;
        }

        public Builder magicMultiplier(int magic) {
            if (magic > 0) magicMultiplier = magic;
            else magicMultiplier = 0;
            return this;
        }

        public abstract HeroAbstract build();
    }
}
