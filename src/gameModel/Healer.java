package gameModel;

public class Healer extends HeroAbstract {

    private Healer() {}

    private Healer(HealerBuilder builder) {
        if (builder == null) return;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Healer{" +
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

    public static class HealerBuilder extends Builder{
        public HealerBuilder(String name) { super(name); }

        public Healer build() {
            return new Healer(this);
        }
    }
}
