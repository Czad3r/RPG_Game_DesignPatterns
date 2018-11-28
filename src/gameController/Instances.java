package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.Draw;

public class Instances {
    public static Game game=new Game();
    public static HeroAbstract player; //(HeroAbstract) new Knight.KnightBuilder("Czader").attackPoints(5).x(100).y(200).build(); // Tu nastąpi inicjalizacja po "Create Character"
    public static Draw drawing ;


}
