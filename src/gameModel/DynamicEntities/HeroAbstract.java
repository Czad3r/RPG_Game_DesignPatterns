package gameModel.DynamicEntities;

import gameController.Handler;
import gameModel.StaticEnities.Entity;
import gameModel.Weapons.WeaponAbstract;

import javax.swing.*;
import java.awt.*;


public abstract class HeroAbstract extends Creature {
    protected int magicMultiplier;
    protected int healingPoints;
    protected WeaponAbstract weapon;

    private long lastAttackTimer,attackCooldown=400,attackTimer=attackCooldown;

    public static final int DEFAULT_MAGIC = 1;
    public static final int DEFAULT_HEALING = 0;

    public HeroAbstract(float x, float y, Handler handler) {
        super(x, y,handler);
        magicMultiplier = DEFAULT_MAGIC;
        healingPoints = DEFAULT_HEALING;
    }

    @Override
    public void die() {
        System.out.println("You died!");
    }

    private int attack() {
        int attack=attackPoints;
        if(weapon!=null)attack+=weapon.getAttackMultiplier();
        return attack;
    }

    @Override
    public void tick() {
        super.tick();
        checkAttacks();
    }

    public void checkAttacks(){
        attackTimer+=System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer=System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle rec=new Rectangle();
        Rectangle collision=getCollisionBounds(0,0);

        int recSize=20; //Range of attack
        rec.width=recSize;
        rec.height=recSize;

        if(handler.getButtonHandler().aUp){
            rec.x=collision.x+collision.width/2 -recSize/2;
            rec.y=collision.y-recSize;
        }
        else if(handler.getButtonHandler().aDown){
            rec.x=collision.x+collision.width/2 -recSize/2;
            rec.y=collision.y+collision.height;
        }
        else if(handler.getButtonHandler().aRight){
            rec.x=collision.x+collision.width;
            rec.y=collision.y+collision.height/2-recSize/2;
        }
        else if(handler.getButtonHandler().aLeft){
            rec.x=collision.x-recSize;
            rec.y=collision.y+collision.height/2-recSize/2;
        }
        else{
            return;
        }

        attackTimer=0;

        for (Entity e:handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))continue;
            if(e.getCollisionBounds(0,0).intersects(rec)){
                setAttacking(true);
                e.hurt(attack());
                return;
            }
        }
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
                ", armorPenetrationPoints="  +
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
        String name;
        Rectangle bounds;

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

        public Builder bounds(int x,int y,int width,int height) {
            this.bounds=new Rectangle(x,y,width,height);
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
