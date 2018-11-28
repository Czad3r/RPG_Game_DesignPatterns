package gameController;

import gameModel.HeroAbstract;
import gameModel.Knight;
import gameView.World;

import java.awt.*;

public class GameState extends State {

    private World world;

    public GameState(Game game) {

        super(game);

        world=new World("res/worlds/world1.txt");

        Instances.game.getGameCamera().move(100,200);
    }

    @Override
    public void tick(){
        world.tick();
        Instances.player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        Instances.player.render(g);
    }
}
