package gameModel;

import gameController.Instances;

import javax.swing.*;

public abstract class HeroAbstract {
    int healthPoints;
    int attackPoints;
    int armorPoints;
    int armorPenetrationPoints;
    int magicMultiplier;
    int healingPoints;

    //Sekcja ruchu
    int x, y;
    boolean left, right, up, down;

    String name;
    Icon icon;

    WeaponAbstract weapon;

    public WeaponAbstract getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponAbstract weapon) {
        this.weapon = weapon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
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


    public static abstract class Builder {
        int healthPoints;
        int attackPoints;
        int armorPoints;
        int armorPenetrationPoints;
        int magicMultiplier;
        int healingPoints;

        WeaponAbstract weapon;

        String name;
        Icon icon;

        public Builder(String name) {
            this.name = name;
        }

        public Builder icon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public Builder weapon(WeaponAbstract weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = 100;
            return this;
        }

        public Builder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = 10;
            return this;
        }

        public Builder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = 0;
            return this;
        }

        public Builder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = 0;
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
