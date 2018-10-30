package gameController;

import gameView.Draw;

// Sposób inicjalizacjio w mainie
//Game ex = new Game();               //Creates new object of type Game, and name it ex.
//new Thread(ex).start();            //Start this so called ex object.
public class Game implements Runnable {


    @Override
    public void run() {

        while(true){
            //Coś robi
            Instances.player.update();
            Instances.drawing.render();
            try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }

}
