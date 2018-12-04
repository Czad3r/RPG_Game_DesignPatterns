package gameController;

import gameController.States.GameState;
import gameController.States.MenuState;
import gameController.States.State;
import gameView.Assets;
import gameView.Draw;
import gameView.GameCamera;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Thread thread;

    private GameCamera gameCamera;

    private Draw drawing;

    private Handler handler;

    //States
    private State gameState;
    private State menuState;

    //Inputs
    private ButtonHandler buttonHandler;

    private boolean running = false;

    private int WIDTH = 640;
    private int HEIGHT = 480;

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
        buttonHandler = new ButtonHandler();

        drawing = new Draw(WIDTH, HEIGHT);
        drawing.getFrame().addKeyListener(buttonHandler);

        handler=new Handler(this);

        gameCamera = new GameCamera(0, 0, handler);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);


        State.setCurrentState(gameState);
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    public Draw getDrawing() {
        return drawing;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
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
