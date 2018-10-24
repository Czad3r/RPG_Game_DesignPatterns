package gameModel;

public class MagicAttack implements Skill{
    String name;
    int attackMultiplier;
    int chanceToStun;
    @Override
    public String getName() {
        return this.name;
    }
}
