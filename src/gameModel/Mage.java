package gameModel;

import java.awt.*;

public class Mage extends HeroAbstract {

    private Mage() {
        super(0,0);
    }

    private Mage(MageBuilder builder) {
        super(0,0);
        if (builder == null) {
            return;
        }
        weapon=builder.weapon;
        healthPoints = builder.healthPoints;
        attackPoints = builder.attackPoints;
        armorPoints = builder.armorPoints;
        armorPenetrationPoints = builder.armorPenetrationPoints;
        name = builder.name;
        magicMultiplier = builder.magicMultiplier;
    }

    @Override
    public String toString() {
        return "Mage"+super.toString();
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void tick() {

    }

    public static class MageBuilder extends Builder {

        public MageBuilder(String name) { super(name); }

        public Mage build() {
            return new Mage(this);
        }
    }

}
