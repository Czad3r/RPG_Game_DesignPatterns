package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.Assets;
import gameView.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private HeroAbstract player;

    public GameState(Handler handler) {
        super(handler);
        world = new World("res/worlds/world1.txt", handler);
        handler.setWorld(world);
        int spawnX=(int)(handler.getWidth()+handler.getGameCamera().getxOffset()/2);
        int spawnY=(int)(handler.getHeight()+handler.getGameCamera().getyOffset()/2);
        player = new Knight.KnightBuilder("Czader",handler).x(spawnX).y(spawnY).width(32).height(32).build();
        handler.getGameCamera().move(100, 200);
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
