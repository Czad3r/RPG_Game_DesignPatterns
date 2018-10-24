package gameModel;

import javax.swing.*;

public class Mage extends HeroAbstract{
    int magicMultiplier;

    public int getMagicMultiplier() {
        return magicMultiplier;
    }

    public void setMagicMultiplier(int magicMultiplier) {
        this.magicMultiplier = magicMultiplier;
    }

    private Mage() {

    }

    private Mage(MageBuilder builder) {
        if (builder == null) {
            return;
        }
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;
        magicMultiplier=builder.magicMultiplier;
    }

    public static class MageBuilder {

        private int healthPoints;
        private int attackPoints;
        private int armorPoints;
        private int armorPenetrationPoints;
        private int magicMultiplier;

        private String name;
        private Icon icon;

        public MageBuilder(String name) {
            this.name = name;
        }

        public MageBuilder icon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public MageBuilder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = 100;
            return this;
        }

        public MageBuilder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = 7;
            return this;
        }

        public MageBuilder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = 2;
            return this;
        }

        public MageBuilder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = 0;
            return this;
        }
        public MageBuilder magicMultiplier(int magic){
            if(magic>0)magicMultiplier=magic;
            else magicMultiplier=2;
            return this;
        }

        public Mage build() {
            return new Mage(this);
        }
    }

}
