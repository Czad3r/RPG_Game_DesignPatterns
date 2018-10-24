package gameModel;

public abstract class WeaponAbstract {
    String name;
    int attackMultiplier;
    int penetrationMultiplier;
    Skill[] skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackMultiplier() {
        return attackMultiplier;
    }

    public void setAttackMultiplier(int attackMultiplier) {
        this.attackMultiplier = attackMultiplier;
    }

    public int getPenetrationMultiplier() {
        return penetrationMultiplier;
    }

    public void setPenetrationMultiplier(int penetrationMultiplier) {
        this.penetrationMultiplier = penetrationMultiplier;
    }
}
