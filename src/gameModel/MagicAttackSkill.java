package gameModel;

public class MagicAttackSkill extends Skill {
    int attackMultiplier;
    int chanceToStun;

    private MagicAttackSkill(){}
    private MagicAttackSkill(Builder builder){
        if(builder==null)return;
        name=builder.name;
        attackMultiplier=builder.attackMultiplier;
        chanceToStun=builder.chanceToStun;
    }

    public static class Builder{
        private String name;
        private int attackMultiplier;
        private int chanceToStun;

        public Builder(String name){
            this.name=name;
        }

        public Builder chanceToStun(int chance){
            if(chance>0)chanceToStun=chance;
            return this;
        }
        public Builder attackMultiplier(int attack){
            if(attack>0)attackMultiplier=attack;
            return this;
        }
        public MagicAttackSkill build(){
            return new MagicAttackSkill(this);
        }
    }


}
