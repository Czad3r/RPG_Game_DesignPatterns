package gameModel;

public class Test {
    public static void main(String[] args) {
        HeroAbstract mójKnight=new Knight.KnightBuilder("Czader").
                            armorPenetrationPoints(5).
                            attackPoints(5).healingPoints(5).build();
        System.out.println( mójKnight.toString());
        System.out.println(mójKnight instanceof Knight);


    }
}
