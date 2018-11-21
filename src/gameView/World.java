package gameView;

import gameController.Utils;
import gameView.tiles.Tile;

import java.awt.*;

public class World {
    private int width, height;
    private int startX,startY;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                getTile(x, y).render(g, Tile.TILEWIDTH * x, Tile.TILEHEIGHT * y);
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path) {
        String file= Utils.loadFileAsString(path);
        String[] tokens =file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        startX=Utils.parseInt(tokens[2]);
        startY=Utils.parseInt(tokens[3]);

        tiles=new int[width][height];
        for (int y=0;y<height;y++){
            for (int x=0;x<width;x++){
                tiles[x][y]=Utils.parseInt(tokens[4 + (x+y*width)]); //Why?
            }
        }
    }
}
