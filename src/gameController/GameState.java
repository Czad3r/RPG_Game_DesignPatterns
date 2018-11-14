package gameController;

import java.awt.*;

public class GameState extends State {

    public GameState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        Instances.player.tick();
    }

    @Override
    public void render(Graphics g) {
        Instances.player.render(g);
    }
}
