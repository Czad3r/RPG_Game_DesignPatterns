package gameModel;

import javax.swing.*;

public abstract class Creature extends Entity {
    protected int healthPoints;
    protected int attackPoints;
    protected int armorPoints;
    protected int armorPenetrationPoints;

    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_ATTACK = 3;
    public static final int DEFAULT_ARMOR = 2;
    public static final int DEFAULT_PENETRATION = 1;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;

    protected String name;

    public Creature(float x, float y) {
        super(x, y);
        healthPoints = DEFAULT_HEALTH;
        attackPoints = DEFAULT_ATTACK;
        armorPoints = DEFAULT_ARMOR;
        armorPenetrationPoints = DEFAULT_PENETRATION;
        width = DEFAULT_CREATURE_WIDTH;
        height = DEFAULT_CREATURE_HEIGHT;
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

    public static abstract class Builder extends Entity.Builder {
        int healthPoints;
        int attackPoints;
        int armorPoints;
        int armorPenetrationPoints;

        String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = DEFAULT_HEALTH;
            return this;
        }

        public Builder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = DEFAULT_ATTACK;
            return this;
        }

        public Builder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = DEFAULT_ARMOR;
            return this;
        }

        public Builder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = DEFAULT_PENETRATION;
            return this;
        }

        public abstract Creature build();
    }
}
