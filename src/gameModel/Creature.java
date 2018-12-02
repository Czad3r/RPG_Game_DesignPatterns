package gameModel;

import gameController.Game;

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



    public Creature(float x, float y,Game game) {
        super(game,x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
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
}
