package gameModel;

public class Knight extends HeroAbstract {
    private Knight() {

    }

    private Knight(KnightBuilder builder) {
        if (builder == null) {
            return;
        }
        weapon=builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Knight"+super.toString();
    }

    public static class KnightBuilder extends Builder {

        public KnightBuilder(String name) { super(name); }

        @Override
        public Knight build() { return new Knight(this); }
    }

}
