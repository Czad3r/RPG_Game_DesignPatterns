package gameModel;

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

    @Override
    public String toString() {
        return "Knight{" +
                "healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", armorPenetrationPoints=" + armorPenetrationPoints +
                ", magicMultiplier=" + magicMultiplier +
                ", healingPoints=" + healingPoints +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }

    public static class KnightBuilder extends Builder {

        public KnightBuilder(String name) { super(name); }

        @Override
        public Knight build() { return new Knight(this); }
    }

}
