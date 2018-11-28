package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.Assets;
import gameView.Draw;
import gameView.GameCamera;

import java.util.logging.Level;
import java.util.logging.Logger;

import static gameController.Instances.drawing;

public class Game implements Runnable {

    private Thread thread;

    private GameCamera gameCamera;

    //States
    private State gameState;
    private State menuState;

    //Inputs
    private ButtonHandler buttonHandler;;

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

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    private void init() {
        Assets.init();
        buttonHandler=new ButtonHandler();
        Instances.player=(HeroAbstract) new Knight.KnightBuilder("Czader").attackPoints(5).x(5*Assets.getWidth()).y(5*Assets.getHeight()).build();
        drawing = new Draw();
        drawing.getFrame().addKeyListener(buttonHandler);


        gameCamera=new GameCamera(0,0);

        gameState = new GameState(this);
        menuState = new MenuState(this);


        State.setCurrentState(gameState);
    }

    public GameCamera getGameCamera() { return gameCamera; }

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
