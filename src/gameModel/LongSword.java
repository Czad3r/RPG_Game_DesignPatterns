package gameModel;

import java.util.Arrays;

public class LongSword extends WeaponAbstract{

    private LongSword() {}

    private LongSword(LongSwordBuilder builder){
        if(builder==null)return;
        name=builder.name;
        attackAddition=builder.attackAddition;
        penetrationAddition=builder.penetrationAddition;
        skills=builder.skills;
    }

    @Override
    public String toString() {
        return "LongSword"+super.toString();
    }

    static class LongSwordBuilder extends Builder{

    public LongSwordBuilder(String name) {
        super(name);
    }

    @Override
    public Builder skills() {
        skills=new Skill[1];
        skills[0]=new CleaveSkill.Builder().chanceToBleed(5).build();
        return this;
    }

    @Override
    public WeaponAbstract build() {
        return new LongSword(this);
    }
}
}
