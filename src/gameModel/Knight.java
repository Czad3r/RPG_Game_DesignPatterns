package gameModel;

import gameController.Game;
import gameView.Assets;

import java.awt.*;

public class Knight extends HeroAbstract {

    private Knight() {
        super(0, 0);

    }

    private Knight(KnightBuilder builder) {
        super(0, 0);
        if (builder == null) {
            return;
        }
        weapon = builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Knight" + super.toString();
    }


    public static class KnightBuilder extends Builder {

        public KnightBuilder(String name) {
            super(name);
        }

        @Override
        public Knight build() {
            return new Knight(this);
        }
    }

}
