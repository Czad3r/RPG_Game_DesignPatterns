package gameModel.DynamicEntities;

import gameController.Handler;

public class Healer extends HeroAbstract {

    private Healer(Handler handler) {
        super(0, 0,handler);
    }

    private Healer(HealerBuilder builder, Handler handler) {
        super(0, 0, handler);
        if (builder == null) return;
        x = builder.x;
        y = builder.y;
        width = builder.width;
        height = builder.height;
        weapon = builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Healer" + super.toString();
    }

    public static class HealerBuilder extends Builder {

        public HealerBuilder(String name, Handler handler) {
            super(name,handler);
        }

        public Healer build() {
            return new Healer(this, handler);
        }
    }
}
