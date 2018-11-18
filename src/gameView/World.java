package gameView;

import gameView.tiles.Tile;

import java.awt.*;

public class World {
    private int width, height;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
    for (int x=0;x<width;x++){
        for (int y=0;y<height;y++){
            getTile(x,y).render(g,Tile.TILEWIDTH*x,Tile.TILEHEIGHT*y);
        }
    }
    }

    public Tile getTile(int x,int y){
        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path) {
width=20;
height=20;
tiles=new int[width][height];
    }
}
