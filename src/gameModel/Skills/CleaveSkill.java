package gameModel.Skills;

public class CleaveSkill extends Skill {
    int chanceToBleed;

    private CleaveSkill() {
    }

    private CleaveSkill(Builder builder) {
        if (builder == null) return;
        name = builder.name;
        chanceToBleed = builder.chanceToBleed;

    }

    @Override
    public String toString() {
        return "CleaveSkill{" +
                "chanceToBleed=" + chanceToBleed+
                '}';
    }

    public static class Builder {
        private String name;
        private int chanceToBleed;

        public Builder() {
            this.name = "Cleave";
        }

        public Builder chanceToBleed(int chance) {
            if (chance > 0) chanceToBleed = chance;
            return this;
        }

        public CleaveSkill build() {
            return new CleaveSkill(this);
        }
    }
}
