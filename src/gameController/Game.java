package gameController;

import gameView.Draw;

import static gameController.Instances.drawing;

// Sposób inicjalizacjio w mainie
//Game ex = new Game();               //Creates new object of type Game, and name it ex.
//new Thread(ex).start();            //Start this so called ex object.
public class Game implements Runnable {

    private Thread thread;

    private boolean running = false;

    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();

            Instances.player.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();
    }

    private void tick() {

    }

    private void render() {
        drawing.render();
    }

    private void init() {
        drawing = new Draw();
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
