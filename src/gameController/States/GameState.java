package gameController.States;

import gameController.EntityManager;
import gameController.Handler;
import gameModel.DynamicEntities.HeroAbstract;
import gameModel.DynamicEntities.Knight;
import gameModel.DynamicEntities.Mage;
import gameView.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private HeroAbstract player;
    private EntityManager entityManager;

    public GameState(Handler handler) {
        super(handler);

        int spawnX=(int)((handler.getWidth()+handler.getGameCamera().getxOffset())/2);
        int spawnY=(int)((handler.getHeight()+handler.getGameCamera().getyOffset())/2);
        player = new Knight.KnightBuilder("Czader",handler).x(spawnX).y(spawnY).width(32).height(32).attackPoints(5).build();

        entityManager = new EntityManager(handler, player);

        world = new World("res/worlds/world1.txt", handler,entityManager);
        handler.setWorld(world);

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
