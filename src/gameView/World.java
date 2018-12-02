package gameView;

import gameController.Game;
import gameController.Utils;
import gameView.tiles.Tile;

import java.awt.*;

public class World {
    private Game game;

    private static int width, height;
    private int startX, startY;
    private int[][] tiles;

    public World(String path,Game game) {
        this.game = game;
        loadWorld(path);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        int xStart = (int)Math.max(0,game.getGameCamera().getxOffset()/Tile.TILEWIDTH) ;
        int xEnd = (int)Math.min(width,game.getGameCamera().getxOffset()+game.getWIDTH()) ;
        int yStart = (int)Math.max(0,game.getGameCamera().getyOffset()/Tile.TILEHEIGHT) ;
        int yEnd = (int)Math.min(height,game.getGameCamera().getxOffset()+game.getHEIGHT()) ;

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
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
        startX = 0;
        startY = 0;

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
