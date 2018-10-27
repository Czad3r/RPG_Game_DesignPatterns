package gameModel;

public class Mage extends HeroAbstract {

    private Mage() {
    }

    private Mage(MageBuilder builder) {
        if (builder == null) {
            return;
        }
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        icon = builder.icon;
        name = builder.name;
        magicMultiplier = builder.magicMultiplier;
    }

    @Override
    public String toString() {
        return "Mage{" +
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

    public static class MageBuilder extends Builder {

        public MageBuilder(String name) { super(name); }

        public Mage build() {
            return new Mage(this);
        }
    }

}
