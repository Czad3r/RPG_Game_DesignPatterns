package gameModel;

import javax.swing.*;

public abstract class creature extends Entity{
    int healthPoints;
    int attackPoints;
    int armorPoints;
    int armorPenetrationPoints;


    String name;
    Icon icon;

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

    public static abstract class Builder {
        int healthPoints;
        int attackPoints;
        int armorPoints;
        int armorPenetrationPoints;

        String name;
        Icon icon;

        public Builder(String name) {
            this.name = name;
        }

        public Builder icon(Icon icon) {
            this.icon = icon;
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

        public abstract creature build();
    }
}
