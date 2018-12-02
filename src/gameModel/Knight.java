package gameModel;

import gameController.Game;
import gameView.Assets;

import java.awt.*;

public class Knight extends HeroAbstract {

    private Knight(Game game) {
        super(0, 0,game);

    }

    private Knight(KnightBuilder builder,Game game) {
        super(0, 0,game);
        if (builder == null) {
            return;
        }
        x=builder.x;
        y=builder.y;
        width=builder.width;
        height=builder.height;
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

        public KnightBuilder(String name,Game game) {

            super(name,game);
        }

        @Override
        public Knight build() {
            return new Knight(this,game);
        }
    }

}
