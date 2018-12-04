package gameModel.DynamicEntities;

import gameController.Handler;

public class Knight extends HeroAbstract {

    private Knight(Handler handler) {
        super(0, 0,handler);

    }

    private Knight(KnightBuilder builder,Handler handler) {
        super(0, 0,handler);
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

        public KnightBuilder(String name,Handler handler) {

            super(name,handler);
        }

        @Override
        public Knight build() {
            return new Knight(this,handler);
        }
    }

}
