package gameModel;

public class Mage extends HeroAbstract {

    private Mage() {
    }

    private Mage(MageBuilder builder) {
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
        magicMultiplier = builder.magicMultiplier;
    }

    @Override
    public String toString() {
        return "Mage"+super.toString();
    }

    public static class MageBuilder extends Builder {

        public MageBuilder(String name) { super(name); }

        public Mage build() {
            return new Mage(this);
        }
    }

}
