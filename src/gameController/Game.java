package gameController;

import gameView.Assets;
import gameView.Draw;

import java.util.logging.Level;
import java.util.logging.Logger;

import static gameController.Instances.drawing;

public class Game implements Runnable {

    private Thread thread;

    //States
    private State gameState;
    private State menuState;

    private boolean running = false;

    private int fps = 60;
    private double timePerTick = 1000000000 / fps; //Time of one frame
    private final Logger ticksLogger = Logger.getLogger("gameTicks");

    @Override
    public void run() {
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        init();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
                Instances.player.update();
            }
            if (timer >= 1000000000) {
                ticksLogger.log(Level.INFO, "Ticks per second= " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    private void tick() {
        if (State.getCurrentState() != null) State.getCurrentState().tick();
    }

    private void render() {
        drawing.render();
    }

    private void init() {
        Assets.init();
        drawing = new Draw();
        gameState = new GameState();
        menuState = new MenuState();
        State.setCurrentState(gameState);
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
