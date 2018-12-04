package gameModel.DynamicEntities;

import gameController.Handler;
import gameModel.Weapons.WeaponAbstract;


public abstract class HeroAbstract extends Creature {
    protected int magicMultiplier;
    protected int healingPoints;
    protected WeaponAbstract weapon;

    public static final int DEFAULT_MAGIC = 1;
    public static final int DEFAULT_HEALING = 0;

    public HeroAbstract(float x, float y, Handler handler) {
        super(x, y,handler);
        magicMultiplier = DEFAULT_MAGIC;
        healingPoints = DEFAULT_HEALING;
    }

    public WeaponAbstract getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponAbstract weapon) {
        this.weapon = weapon;
    }


    public int getMagicMultiplier() {
        return magicMultiplier;
    }

    public void setMagicMultiplier(int magicMultiplier) {
        this.magicMultiplier = magicMultiplier;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

    @Override
    public String toString() {
        return "{" +
                "healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", armorPenetrationPoints=" + armorPenetrationPoints +
                ", magicMultiplier=" + magicMultiplier +
                ", healingPoints=" + healingPoints +
                ", weapon=" + weapon +
                ", name='" + name + '\'' +
                '}';
    }




    public static abstract class Builder {
        Handler handler;
        float x, y;
        int width, height;
        int magicMultiplier;
        int healingPoints;
        int healthPoints;
        int attackPoints;
        int armorPoints;
        int armorPenetrationPoints;
        String name;

        WeaponAbstract weapon;


        public Builder(String name,Handler handler) {
            this.name=name;
            this.handler =handler;
        }

        public Builder x(float x) {
            this.x = x;
            return this;
        }
        public Builder y(float y) {
            this.y = y;
            return this;
        }

        public Builder healthPoints(int health) {
            if(health>0)this.healthPoints=health;
            else health=100;
            return this;
        }
        public Builder attackPoints(int attackPoints) {
            if(attackPoints>0)this.attackPoints=attackPoints;
            else attackPoints=10;
            return this;
        }
        public Builder armorPoints(int armorPoints) {
            if(armorPoints>0)this.armorPoints=armorPoints;
            else armorPoints=5;
            return this;
        }
        public Builder armorPenetrationPoints(int armorPenetrationPoints) {
            if(armorPenetrationPoints>0)this.armorPenetrationPoints=armorPenetrationPoints;
            else armorPenetrationPoints=2;
            return this;
        }
        public Builder width(int width) {
            if(width>0)this.width = width;
            else this.width=32;
            return this;
        }
        public Builder height(int height) {
            if(height>0)this.height = height;
            else this.height=32;
            return this;
        }

        public Builder weapon(WeaponAbstract weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder healingPoints(int heal) {
            if (heal > 0) healingPoints = heal;
            else heal = DEFAULT_HEALING;
            return this;
        }

        public Builder magicMultiplier(int magic) {
            if (magic > 0) magicMultiplier = magic;
            else magicMultiplier = DEFAULT_MAGIC;
            return this;
        }

        public abstract HeroAbstract build();
    }
}
