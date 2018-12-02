package gameView;

import gameController.Game;
import gameController.Handler;
import gameController.Utils;
import gameView.tiles.Tile;

import java.awt.*;

public class World {
    private Handler handler;

    private static int width, height;
    private int startX, startY;
    private int[][] tiles;

    public World(String path, Handler handler) {
        this.handler=handler ;
        loadWorld(path);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        int xStart = (int)Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILEWIDTH) ;
        int xEnd = (int)Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1) ;
        int yStart = (int)Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT) ;
        int yEnd = (int)Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEWIDTH+1);

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                getTile(x, y).render(g, (int) (Tile.TILEWIDTH * x - handler.getGameCamera().getxOffset()),
                        (int) (Tile.TILEHEIGHT * y - handler.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        if(x<0 || y<0 || x>=width || y >=height)return Tile.grassTile;

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
