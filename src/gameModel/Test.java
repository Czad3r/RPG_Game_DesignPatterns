package gameModel;

import gameController.Game;

public class Test {
    public static void main(String[] args) {
        Game ex = new Game();
        new Thread(ex).start();


    }
}
