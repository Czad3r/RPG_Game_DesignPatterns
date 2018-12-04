package gameModel.DynamicEntities;

import gameController.Handler;

import java.awt.*;

public class Mage extends HeroAbstract {

    private Mage(Handler handler) {
        super(0,0,handler);
    }

    private Mage(MageBuilder builder,Handler handler) {
        super(0,0,handler);
        if (builder == null) {
            return;
        }
        x=builder.x;
        y=builder.y;
        width=builder.width;
        height=builder.height;
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

        public MageBuilder(String name, Handler handler) {
            super(name,handler);
        }

        public Mage build() {
            return new Mage(this, handler);
        }
    }

}
