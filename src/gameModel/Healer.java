package gameModel;

import javax.swing.*;

public class Healer extends HeroAbstract{
    int healingPoints;

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

    private Healer(){}
    private Healer(HealerBuilder builder){

        if(builder==null)return;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;
    }
public static class HealerBuilder
    {
        private int healthPoints;
        private int attackPoints;
        private int armorPoints;
        private int armorPenetrationPoints;
        private int healingPoints;

        private String name;
        private Icon icon;

        public HealerBuilder(String name) {
            this.name = name;
        }

        public HealerBuilder icon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public HealerBuilder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = 90;
            return this;
        }

        public HealerBuilder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = 6;
            return this;
        }

        public HealerBuilder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = 2;
            return this;
        }

        public HealerBuilder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = 0;
            return this;
        }
        public HealerBuilder healingPoints(int heal){
            if(heal>0)healingPoints=heal;
            else heal=8;
            return this;
        }

        public Healer build() {
            return new Healer(this);
        }
    }
}
