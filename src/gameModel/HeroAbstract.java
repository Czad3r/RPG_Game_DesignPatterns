package gameModel;

import javax.swing.*;

public abstract class HeroAbstract {
    int healthPoints;
    int attackPoints;
    int armorPoints;
    int armorPenetrationPoints;
    int magicMultiplier;
    int healingPoints;

    String name;
    Icon icon;

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
        return "HeroAbstract{" +
                "healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", armorPenetrationPoints=" + armorPenetrationPoints +
                ", magicMultiplier=" + magicMultiplier +
                ", healingPoints=" + healingPoints +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }

    public static abstract class Builder {
        protected int healthPoints;
        protected int attackPoints;
        protected int armorPoints;
        protected int armorPenetrationPoints;
        protected int magicMultiplier;
        protected int healingPoints;

        protected String name;
        protected Icon icon;

        public Builder(String name) {
            this.name = name;
        }

        public Builder icon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public Builder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = 90;
            return this;
        }

        public Builder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = 6;
            return this;
        }

        public Builder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = 2;
            return this;
        }

        public Builder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = 0;
            return this;
        }

        public Builder healingPoints(int heal) {
            if (heal > 0) healingPoints = heal;
            else heal = 8;
            return this;
        }

        public Builder magicMultiplier(int magic){
            if(magic>0)magicMultiplier=magic;
            else magicMultiplier=2;
            return this;
        }

        public abstract HeroAbstract build();
    }
}
