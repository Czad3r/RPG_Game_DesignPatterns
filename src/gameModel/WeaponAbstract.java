package gameModel;

import java.util.Arrays;

public abstract class WeaponAbstract {
    protected String name;
    protected int attackAddition;
    protected int penetrationAddition;
    protected Skill[] skills;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", attackAddition=" + attackAddition +
                ", penetrationAddition=" + penetrationAddition +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAttackMultiplier() {
        return attackAddition;
    }

    public void setAttackMultiplier(int attackAddition) {
        this.attackAddition = attackAddition;
    }

    public int getPenetrationAddition() {
        return penetrationAddition;
    }

    public void setPenetrationAddition(int penetrationAddition) {
        this.penetrationAddition = penetrationAddition;
    }

    static abstract class Builder{
        protected String name;
        protected int attackAddition;
        protected int penetrationAddition;
        protected Skill[] skills;

        public Builder(String name){ this.name=name; }

        public Builder attackAddition(int attackAddition){
            if(attackAddition>0)this.attackAddition=attackAddition;
            attackAddition=0;
            return this;
        }
        public Builder penetrationAddition(int penetrationAddition){
            if(penetrationAddition>0)this.penetrationAddition=penetrationAddition;
            penetrationAddition=0;
            return this;
        }
        public abstract Builder skills();

        public abstract WeaponAbstract build();
    }
}
