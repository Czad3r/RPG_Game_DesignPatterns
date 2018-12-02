package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private HeroAbstract player;

    public GameState(Game game) {

        super(game);
        player = new Knight.KnightBuilder("Czader",game).x(5).y(5).width(32).height(32).build();

        world = new World("res/worlds/world1.txt", game);

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
