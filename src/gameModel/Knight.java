package gameModel;

import javax.swing.*;

public class Knight extends HeroAbstract {
    private Knight() {

    }

    private Knight(KnightBuilder builder) {
        if (builder == null) {
            return;
        }
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;

    }

    public static class KnightBuilder {

        private int healthPoints;
        private int attackPoints;
        private int armorPoints;
        private int armorPenetrationPoints;

        private String name;
        private Icon icon;

        public KnightBuilder(String name) {
            this.name = name;
        }

        public KnightBuilder icon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public KnightBuilder healthPoints(int hp) {
            if (hp > 0) healthPoints = hp;
            else healthPoints = 120;
            return this;
        }

        public KnightBuilder attackPoints(int attack) {
            if (attack > 0) this.attackPoints = attack;
            else attack = 10;
            return this;
        }

        public KnightBuilder armorPoints(int armor) {
            if (armor > 0) armorPoints = armor;
            else armorPoints = 5;
            return this;
        }

        public KnightBuilder armorPenetrationPoints(int pen) {
            if (pen > 0) armorPenetrationPoints = pen;
            else armorPenetrationPoints = 2;
            return this;
        }

        public Knight build() {
            return new Knight(this);
        }
    }
}
