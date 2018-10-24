package gameModel;

public class Test {
    public static void main(String[] args) {
        Knight mójKnight=new Knight.KnightBuilder("Czader").build();
        System.out.println( mójKnight.toString());

    }
}
