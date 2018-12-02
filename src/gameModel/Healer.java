package gameModel;

import gameController.Game;

public class Healer extends HeroAbstract {

    private Healer(Game game) {
        super(0, 0, game);
    }

    private Healer(HealerBuilder builder, Game game) {
        super(0, 0, game);
        if (builder == null) return;
        x = builder.x;
        y = builder.y;
        width = builder.width;
        height = builder.height;
        weapon = builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Healer" + super.toString();
    }

    public static class HealerBuilder extends Builder {

        public HealerBuilder(String name, Game game) {
            super(name,game);
        }

        public Healer build() {
            return new Healer(this,game);
        }
    }
}
