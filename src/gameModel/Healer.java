package gameModel;

public class Healer extends HeroAbstract {

    private Healer() {
        super(0,0);
    }

    private Healer(HealerBuilder builder) {
        super(0,0);
        if (builder == null) return;
        weapon=builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Healer"+super.toString();
    }

    public static class HealerBuilder extends Builder{
        public HealerBuilder(String name) { super(name); }

        public Healer build() {
            return new Healer(this);
        }
    }
}
