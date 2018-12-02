package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private HeroAbstract player;

    public GameState(Handler handler) {
        super(handler);
        world = new World("res/worlds/world1.txt", handler);
        handler.setWorld(world);
        player = new Knight.KnightBuilder("Czader",handler).x(100).y(100).width(32).height(32).build();
        //game.getGameCamera().move(100, 200);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
