package gameModel;

public class BlockSkill extends Skill{
    int chanceToBlock;

    private BlockSkill(){}
    private BlockSkill(Builder builder){
        if(builder==null)return;
        name=builder.name;
        chanceToBlock=builder.chanceToBlock;

    }
    public static class Builder{
        private String name;
        private int chanceToBlock;

        public Builder(String name){
            this.name=name;
        }
        public Builder chanceToBlock(int chance){
            if(chance>0)chanceToBlock=chance;
            return this;
        }

        public BlockSkill build(){
            return new BlockSkill(this);
        }

    }

}
