package gameModel;

import javax.swing.*;

public abstract class HeroAbstract {
    int healthPoints;
    int attackPoints;
    int armorPoints;
    int armorPenetrationPoints;

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
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
