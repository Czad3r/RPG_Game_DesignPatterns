package gameView;

import gameController.Game;
import gameController.Instances;
import gameController.Utils;
import gameView.tiles.Tile;

import java.awt.*;

public class World {
    private Game game;

    private static int width, height;
    private int startX, startY;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
        this.game = Instances.game;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                getTile(x, y).render(g, (int) (Tile.TILEWIDTH * x - game.getGameCamera().getxOffset()),
                                        (int) (Tile.TILEHEIGHT * y - game.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        startX = (int)Instances.player.getX();
        startY = (int)Instances.player.getY();

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[2 + (x + y * width)]); //Why?
            }
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
