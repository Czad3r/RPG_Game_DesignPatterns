package gameModel;

import gameController.Game;

import java.awt.*;

public class Mage extends HeroAbstract {

    private Mage(Game game) {
        super(0,0,game);
    }

    private Mage(MageBuilder builder,Game game) {
        super(0,0,game);
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

        public MageBuilder(String name,Game game) {
            super(name,game);
        }

        public Mage build() {
            return new Mage(this,game);
        }
    }

}
