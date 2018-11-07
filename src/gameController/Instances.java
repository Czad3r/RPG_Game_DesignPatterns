package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.Draw;

public class Instances {
    public static HeroAbstract player=new Knight.KnightBuilder("Czader").attackPoints(5).build(); // Tu nastąpi inicjalizacja po "Create Character"
    public static Draw drawing ;

}
