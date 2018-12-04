package gameController;

import gameController.Inputs.ButtonHandler;
import gameController.Inputs.MouseHandler;
import gameView.GameCamera;
import gameView.World;

public class Handler {
    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public ButtonHandler getButtonHandler() {
        return game.getButtonHandler();
    }

    public int getWidth() {
        return game.getWIDTH();
    }

    public int getHeight() {
        return game.getHEIGHT();
    }

    //Gettery
    public MouseHandler getMouseHandler() {
        return game.getMouseHandler();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
